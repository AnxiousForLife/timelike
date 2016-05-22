package game.engine

import game._
import game.LockState._
import game.PlayerAction._

class Engine(val state: GameState) {
  var keepRunning = true

  def gameLoop() = {
    while (keepRunning) {
      println(s"${state.direction}")
      Output.showState(state)

      val input = getInput()
      matchAction(InputParser.parseAction(input))
    }
  }

  def getInput() = scala.io.StdIn.readLine().toLowerCase

  def matchAction(a: (PlayerAction, Option[Argument])) = {
    a match {
      case (InvalidAction, _) => Output.showInvalid()
      case (Turn, x) => tryTurn(x)
      case (Open, x) => tryOpen(x)
      case (Enter, x) => tryEnter(x)
      case (TakeItem, x) => tryTake(x)
      case (Unlock, x) => tryUnlock(x)
      case (Rewind, _) => rewind()
    }
  }

  def tryTurn(a: Option[Argument]) = {
    a match {
      case None => Output.showAmbiguousDirection()
      case Some(rd: RelativeDirection) => {
        state.actions(Turn)(rd)
        Output.showTurn(rd)
      }
      case Some(a) => Output.showNotADirection(a)
    }
  }

  def tryEnter(a: Option[Argument]) = {
    a match {
      case Some(Room) | Some(Doorway) | None => {
        state.currentWall.door match {
          case None => Output.showNoExit()
          case Some(door: Door) => {
            if (door.isOpen) {
              state.enterRoom(door)
              Output.showEnterRoom()
            }
            else Output.showDoorClosed()
          }
        }
      }
      case _ => Output.showCantEnter()
    }
  }

  def tryUnlock(a: Option[Argument]) = {
    a match {
      case Some(o: Openable) => unlock(o)
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

  def unlock(o: Openable) = {
    if (!o.isUnlocked) {
      o.lock match {
        case Unlocked => println("ERROR: Already Unlocked.")
        case k: KeyLock => {
          if (Inventory.contains(k.key)) {
            o.actions(Unlock)
            Output.showUnlock(o)
          }
          else Output.showNoKey()
        }
        case Barred => Output.showCantUnlockBars()
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
        else Output.showInvalidTake()
      }
      case Some(x) => {
        if (state.currentWall.availArguments.contains(x)) Output.showCantTake()
        else Output.showInvalidTake()
      }
    }
  }

  def take(i: Item) = {
    i.actions(TakeItem)
      Output.showTakeItem(i)
  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (state.log.length > 1) {
      state.actions(Rewind)
      Output.showRewind()
    } else Output.showBlockRewind()
  }

  def tryOpen(a: Option[Argument]) = {
    a match {
      case Some(o: Openable) => open(o)
      case Some(x) => Output.showCantOpen(x)
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

  def open(o: Openable) = {
    o.lock match {
      case _: KeyLock => Output.showKeyLocked()
      case Barred => Output.showDoorBarred()
      case Unlocked => {
        if (!o.isOpen) {
          o.actions(Open)
          Output.showOpen(o)
        }
        else Output.showAlreadyOpened(o)
      }
    }
  }

}
