package game.engine

import game.{Argument, _}
import game.assets.Objectives._
import game.LockState._
import game.PlayerAction._
import game.RelativeDirection._
import game.assets.Items.Locket
import game.assets.{Items, Keys}

import scala.util.Try

class Engine(val state: GameState) {
  Output.showTitle()
  pressAnyKeyTitle()

  Output.showRoom(state)

  var keepRunning = true

  def gameLoop() = {
    while (keepRunning) {
      unclearedObjectives()
      val input = getInput
      matchAction(InputParser.parseAction(input, state))
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

  def argOptions(x: AmbiguousResult): Option[Argument] = {
    val input = getInput
    if (Try(input.toInt).isSuccess && (1 to x.args.length).contains(input.toInt)) Some(x.args(input.toInt - 1))
    else Output.showInvalid()
    argOptions(x)
  }

  def matchAction(a: PlayerAction) = {
    a match {
      case InvalidAction => Output.showInvalid()
      case Rewind => rewind()
      case x: OneTargetAction => {
        x.input1 match {
          case None => matchTargetAction(a, None)
          case Some(x: AmbiguousResult) => {
            Output.showAmbiguousArg(x.args)
            val input = getInput
            var askForArg = true
            while (askForArg) {
              if (Try(input.toInt).isSuccess && (1 to x.args.length).contains(input.toInt)) {
                askForArg = false
                matchTargetAction(a, Some(x.args(input.toInt - 1)))
              }
              else Output.showInvalid()
            }
          }
          case Some(x: ArgumentResult) => matchTargetAction(a, Some(x.arg))
        }
      }
    }
  }

  def matchTargetAction(a: PlayerAction, arg: Option[Argument]) = {
    a match {
      case x: Examine => examine(arg)
      case x: Turn => tryTurn(arg)
      case x: Open => tryOpen(arg)
      case x: Close => tryClose(arg)
      case x: Enter => tryEnter(arg)
      case x: TakeItem => tryTake(arg)
      case x: Unlock => tryUnlock(arg)
      case x: Pull => tryPull(arg)
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
        val items = state.availItems
        items.length match {
          case 0 => Output.showNoItem()
          case 1 => take(items.head)
          case n if n > 1 => Output.showAmbiguousTake(items)
        }
      }
      case Some(i: Item) => {
        if (state.availItems.contains(i)) take(i)
        else Output.showUnavailableArgument()
      }
      case Some(x) => {
        if (state.availArguments.contains(x)) Output.showCantTake()
        else Output.showUnavailableArgument()
      }
    }
  }

  def take(i: Item) = {
    i.take()
    Output.showTakeItem(i)
  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (Inventory.contains(Locket)){
      if (state.log.length > 1) {
        state.lastState()
        Output.showRewind()
      } else Output.showBlockRewind()
    }
    else Output.showInvalid()
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
            case c: Container => {
              Output.showContents(state, c)
            }
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
