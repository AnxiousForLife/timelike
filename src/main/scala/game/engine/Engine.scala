package game.engine

import game.{Argument, _}
import game.assets.Objectives._
import game.LockState._
import game.PlayerAction._
import game.RelativeDirection._
import game.assets.Items.{GameMap, Locket}
import game.assets.{Items, Keys, Scales}

import scala.util.Try

class Engine(val state: GameState) {
  Scales.list.foreach(x => updateScale(x))

  Output.showTitle()
  pressAnyKeyTitle()

  Output.showRoom(state)
  unclearedObjectives()

  var keepRunning = true

  def gameLoop() = {
    while (keepRunning) {
      val input = getInput
      matchAction(InputParser.parseAction(input, state))
    }
  }

  def showDirection() = {
    Output.showFOV(state)
    unclearedObjectives()
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

  def matchAction(a: PlayerAction): Unit = {
    a match {
      case InvalidAction => Output.showInvalid()
      case CheckMap => checkMap()
      case CheckCompass => checkCompass()
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
      case x: PlaceItem => tryPlace(arg)
      case x: UseItem => tryUseItem(arg)
      case x: Unlock => tryUnlock(arg)
      case x: Pull => tryPull(arg)
    }
  }

  def examine(a: Option[Argument]) = {
    a match {
      case None => showDirection()
      case Some(_) => showDirection()
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
        showDirection()
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
        val items = state.availItems.filter(_.location != Inventory)
        items.length match {
          case 0 => Output.showNoItem()
          case 1 => take(items.head)
          case n if n > 1 => Output.showAmbiguousTake(items)
        }
      }
      case Some(i: Item) => {
        if (state.availItems.contains(i))
          take(i)
        else
          Output.showUnavailableArgument()
      }
      case Some(x) => {
        if (state.allAvailArguments.contains(x))
          Output.showCantTake()
        else
          Output.showUnavailableArgument()
      }
    }
  }

  def take(i: Item) = {
    val oldLocation = i.location
    Output.showTakeItem(i, i.location)
    i.take()
    checkUpdateScale(oldLocation)
  }

  def tryPlace(a: Option[Argument]) = {
    a match {
      case None => {
        Output.showInventory(state)
      }
      case Some(i: Item) => {
        if (Inventory.contains(i)) {
          val ls = state.currentWall.availLocations
          if (ls.length == 1) {
            placeItem(i, ls.head)
          }
          else {
            Output.showAskLocation(ls)
            val input = getInput
            var askForArg = true
            while (askForArg) {
              if (Try(input.toInt).isSuccess && (1 to ls.length).contains(input.toInt)) {
                askForArg = false
                placeItem(i, ls(input.toInt - 1))
              }
              else Output.showInvalid()
            }
          }
        }
        else Output.showDontHaveItem()
      }
      case Some(_) => Output.showDontHaveItem()
    }
  }

  def locationHasRoom(l: ItemLocation): Boolean = {
    l match {
      case x: Top if x.a.isInstanceOf[Scale] => {
        state.itemsAtLocation(x).length match {
          case 1 => false
          case 0 => {
            true
          }
        }
      }
      case _ => {
        true
      }
    }
  }

  def placeItem(i: Item, l: ItemLocation) = {
    if (locationHasRoom(l)) {
      i.location = l
      Output.showPlaceItem(i, l)
      checkUpdateScale(l)
    }
    else
      Output.showCantPlace()
  }

  def tryUseItem(a: Option[Argument]) = {
    a match {
      case None => {
        Output.showInventory(state)
      }
      case Some(i: Item) => {
        if (Inventory.contains(i)) {
          matchAction(i.useAction)
        }
        else Output.showDontHaveItem()
      }
      case Some(_) => Output.showDontHaveItem()
    }
  }

  def checkMap() = Output.showMap(state)

  def checkCompass() = Output.showDirection(state)

  def checkUpdateScale(l: ItemLocation) = {
    l match {
      case x: Top if x.a.isInstanceOf[Scale] => {
        val s = x.a.asInstanceOf[Scale]
        updateScale(s)
      }
      case _ => {}
    }
  }

  def updateScale(s: Scale) = {
    val totalWeight = state.itemsAtLocation(s.top).filter(_.isInstanceOf[Sandbag]).asInstanceOf[Seq[Sandbag]].foldLeft(0)((x, y) => x + y.amt)
    if (totalWeight == s.weight) {
      s.state = Balanced
      s.availability = Unavailable
      Output.showScaleActivated(s)
    }
    else if (totalWeight > s.weight)
      s.state = Depressed
    else
      s.state = Raised
    s.update()
  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (Inventory.contains(Locket)) {
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
        val levers = state.currentWall.availSwitches
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
