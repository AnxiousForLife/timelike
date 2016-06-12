package game.engine

import game.{Argument, _}
import game.assets.Objectives._
import game.LockState._
import game.PlayerAction._
import game.RelativeDirection._
import game.assets.{Items, Keys}

class Engine(val state: GameState) {
  Keys.list.foreach(x => Item.update(x))
  Items.list.foreach(x => Item.update(x))

  Output.showTitle()
  pressAnyKeyTitle()

  Output.showRoom(state)

  var keepRunning = true

  def gameLoop() = {
    while (keepRunning) {
      unclearedObjectives()
      val input = getInput
      matchAction(InputParser.parseAction(input, state.currentWall))
    }
  }

  def unclearedObjectives() = {
    state.currentWall.objective match {
      case None => {}
      case Some(o) => {
        if (!o.isCleared) o match {
          case ExitFirstRoom => Output.showFirstWalk()
          case FirstTurn => Output.showFirstTurn()
          case ClearGame => Output.showEscape()
        }
      }
    }
  }

  def pressAnyKeyTitle() = {
    Output.showReturnTitle()
    Console.in.read.toChar
  }

  def pressAnyKeyShort() = {
    Output.showReturnShort()
    Console.in.read.toChar
  }

  def getInput = scala.io.StdIn.readLine().toLowerCase.trim()

  def matchAction(a: PlayerAction) = {
    a match {
      case InvalidAction => Output.showInvalid()
      case x: Examine => examine(x.arg)
      case x: Turn => tryTurn(x.arg)
      case x: Open => tryOpen(x.arg)
      case x: Close => tryClose(x.arg)
      case x: Enter => tryEnter(x.arg)
      case x: TakeItem => tryTake(x.arg)
      case x: Unlock => tryUnlock(x.arg)
      case x: Pull => tryPull(x.arg)
      case Rewind => rewind()
    }
  }

  def examine(a: Option[Argument]) = {
    a match {
      case None => Output.showFOV(state)
      case Some(_) => Output.showFOV(state)
    }
  }

  def tryTurn(a: Option[Argument]) = {
    a match {
      case None => Output.showAmbiguousDirection()
      case Some(rd: RelativeDirection) => {
        state.currentWall.objective match {
          case Some(FirstTurn) => {
            rd match {
              case Right => FirstTurn.clear()
              case _ => {}
            }
          }
          case _ => {}
        }
        state.turn(rd)
        Output.showTurn(rd)
        Output.showFOV(state)
      }
      case Some(x) => Output.showNotADirection(x)
    }
  }

  def tryEnter(a: Option[Argument]) = {
    a match {
      case Some(_: Room) | None => {
        state.currentWall.door match {
          case None => Output.showNoExit()
          case Some(doorway: Doorway) => {
            doorway match {
              case door: Door => {
                if (door.isOpen) enter(door)
                else Output.showDoorClosed()
              }
              case _ => enter(doorway)
            }
          }
        }
      }
      case _ => Output.showCantEnter()
    }
  }

  def enter(doorway: Doorway) = {
    state.currentWall.objective match {
      case Some(ExitFirstRoom) => ExitFirstRoom.clear()
      case _ => {}
    }
    state.enterRoom(doorway)
    Output.showEnterRoom(doorway)
    Output.showRoom(state)
  }

  def tryUnlock(a: Option[Argument]) = {
    a match {
      case Some(o: ConcreteArgument with Openable) => unlock(o)
      case None => {
        val openables = state.currentWall.availOpenables
        openables.length match {
          case 0 => Output.showNoUnlockable()
          case 1 => unlock(openables.head)
          case n if n > 1 => Output.showAmbiguousOpen(openables)
        }
      }
      case _ => Output.showCantUnlock()
    }
  }

  def unlock(o: ConcreteArgument with Openable) = {
    if (!o.isUnlocked) {
      o.lock match {
        case Unlocked => println("ERROR: Already Unlocked.")
        case k: KeyLock => {
          if (Inventory.contains(k.key)) {
            o.unlock()
            Output.showUnlock(o)
          }
          else Output.showNoKey()
        }
        case _: Barred => Output.showCantUnlockBars()
      }
    }
    else if (!o.isOpen) Output.showAlreadyUnlocked(o)
    else Output.showAlreadyOpened(o)
  }

  def tryTake(a: Option[Argument]) = {
    a match {
      case None => {
        val items = state.currentWall.availItems
        items.length match {
          case 0 => Output.showNoItem()
          case 1 => take(items.head)
          case n if n > 1 => Output.showAmbiguousTake(items)
        }
      }
      case Some(i: Item) => {
        if (state.currentWall.availItems.contains(i)) take(i)
        else Output.showUnavailableArgument()
      }
      case Some(x) => {
        if (state.currentWall.availArguments.contains(x)) Output.showCantTake()
        else Output.showUnavailableArgument()
      }
    }
  }

  def take(i: Item) = {
    i.take()
      Output.showTakeItem(i)
  }

  def place(i: Item) = {

  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (state.log.length > 1) {
      state.lastState()
      Output.showRewind()
    } else Output.showBlockRewind()
  }

  def tryOpen(a: Option[Argument]) = {
    a match {
      case Some(o: ConcreteArgument with Openable) => open(o)
      case Some(x) => {
        if (state.currentWall.arguments.contains(x)) Output.showCantOpen()
        Output.showUnavailableArgument()
      }
      case None => {
        val openables = state.currentWall.availOpenables
        openables.length match {
          case 0 => Output.showNoOpenable()
          case 1 => open(openables.head)
          case n if n > 1 => Output.showAmbiguousOpen(openables)
        }
      }
    }
  }

  def open(o: ConcreteArgument with Openable) = {
    o.lock match {
      case _: KeyLock => Output.showKeyLocked(o)
      case _: Barred => Output.showDoorBarred()
      case Unlocked => {
        if (!o.isOpen) {
          o.open()
          Output.showOpen(o)
          o match {
            case c: Container => {Output.showContents(c)}
            case _ => {}
          }
        }
        else Output.showAlreadyOpened(o)
      }
    }
  }

  def tryClose(a: Option[Argument]) = {
    a match {
      case Some(o: ConcreteArgument with Openable) => close(o)
      case Some(x) => {
        if (state.currentWall.arguments.contains(x)) Output.showCantClose()
        Output.showUnavailableArgument()
      }
      case None => {
        val closeables = state.currentWall.availOpenables
        closeables.length match {
          case 0 => Output.showNoCloseable()
          case 1 => close(closeables.head)
          case n if n > 1 => Output.showAmbiguousClose(closeables)
        }
      }
    }
  }

  def close(o: ConcreteArgument with Openable) = {
    if (o.isOpen) {
      o.close()
      Output.showClose(o)
    } else Output.showAlreadyClosed(o)
  }

  def tryPull(a: Option[Argument]) = {
    a match {
      case Some(l: PullChain) => pullLever(l)
      case Some(x) => Output.showCantOpen()
      case None => {
        val levers = state.currentWall.availLevers
        levers.length match {
          case 0 => Output.showNoLever()
          case 1 => pullLever(levers.head)
          case n if n > 1 => Output.showAmbiguousPull(levers)
        }
      }
    }
  }

  def pullLever(l: PullChain) = {
    l.pull()
    Output.showPull()
  }
}
