package game.engine

import game._
import game.RoomObject._
import game.LockState._
import game.PlayerAction._
import game.util.Circular

import scala.collection.mutable

class Engine(val state: GameState) {
  var keepRunning = true

  def gameLoop() = {
    while (keepRunning) {
      Output.showState(state)

      val input = getInput()
      matchAction(InputParser.parseAction(input))
    }
  }

  def getInput() = scala.io.StdIn.readLine().toLowerCase

  def matchAction(a: PlayerAction) = {
    a match {
      case InvalidAction => Output.showInvalid()
      case Quit => quit()
      case x: Turn => turn(x.arg)
      case x: Open => tryOpen(x.arg)
      case x: StartSearch => trySearch(x.arg)
      case Rewind => rewind()
    }
  }

  def quit() { keepRunning = false }

  def turn(a: Argument) = {
    a match {
      case rd: RelativeDirection => {
        state.updateDirection(state.direction.turn(rd))
        Output.showTurn(rd)
      }
      case _ => Output.showNotADirection(a)
    }
  }

  def open(o: Openable) = {
    o match {
      case d: Door => tryExit()
    }
  }

  def tryExit() = {
    //Is there a door?
    state.currentWall.door match {
      case None => Output.showNoExit()
      case Some(door: Door) => {
        if (doorWillOpen(door)) {
          enterRoom(door)
        }
        else Output.showNoExit()
      }
    }
  }

  //Entering a room
  def enterRoom(door: Door) = {
    //Is the player moving clockwise?/Does the player change direction in the next room?
    (state.room.outwardFace == state.direction.left.left, door) match {
      case (true, _: AngledDoor) => {
        state.updateRoom(door.room2)
        state.updateDirection(state.direction.right)
      }
      case (false, _: AngledDoor) => {
        state.updateRoom(door.room1)
        state.updateDirection(state.direction.left)
      }
      case (true, _) => state.updateRoom(door.room2)
      case (false, _) => state.updateRoom(door.room1)
    }
    Output.showEnterRoom()
  }

  //Is the door locked?
  def doorWillOpen(door: Door): Boolean = {
    door.lock match {
      case Unlocked => true
      case Barred => {
        Output.showDoorBarred()
        false
      }
      case keyLock: KeyLock => {
        //Does the player have the right key?
        if (state.inventory.contains(keyLock.key)) {
          door.lock = Unlocked
          Output.showUnlock()
          true
        } else {
          Output.showKeyLocked()
          false
        }
      }
    }
  }

  def availContainers: Seq[ItemLocation] = {
    val roomObj = state.currentWall.roomObject match {
      case Some(c: ItemLocation) => Seq[ItemLocation](c)
      case _ => Seq.empty[ItemLocation]
    }
    state.currentWall +: roomObj
  }

  def availItems: mutable.Set[Item] = {
    Item.list.filter(x => availContainers.contains(x.location))
  }

  def availOpenables: Seq[Openable] = {
    val door = state.currentWall.door match {
      case Some(d: Door with Openable) => Seq[Openable](d)
      case _ => Seq.empty[Openable]
    }
    val roomObj = state.currentWall.roomObject match {
      case Some(c: Openable) => Seq[Openable](c)
      case _ => Seq.empty[Openable]
    }
    door ++ roomObj
  }

  def takeItem(i: Item) = {
    if (availItems.isEmpty) Output.showTakeNothing()
    else {
      i.location = Inventory
      Output.showTakeItem(i)
    }
  }

  //Searching through cabinets
  def trySearch(a: Option[Argument]) = {
    a match {
      case Some(Cabinet) | Some(Drawer) | None => {
        state.currentWall.roomObject match {
          case Some(cabinet: Cabinet) => {
            var keepSearching = true
            val it = new Circular(cabinet.drawers)

            while (keepSearching) {
              it.current.open()
              Output.showDrawer(it.current, cabinet.drawers.indexOf(it.current) + 1)
              val input = getInput()
              val action = InputParser.parseSearchAction(input)
              action match {
                //###TAKE ITEM GOES HERE###
                case _: TakeItem => {}
                case _ => {
                  it.current.close()
                  action match {
                    case StopSearch => keepSearching = false
                    case NextDrawer => it.next
                    case PrevDrawer => it.prev
                  }
                }
              }
            }
          }
          case _ => Output.showNoSearch()
        }
      }
      case _ => Output.showNotSearchable()
    }
  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (state.log.length > 1) {
      state.lastState
      Output.showRewind()
    } else Output.showBlockRewind()
  }

  def tryOpen(a: Option[Argument]) = {
    a match {
      case Some(o: Openable) => open(o)
      case Some(x) => Output.showCantOpen(x)
      case None => {
        val openables = availOpenables
        openables.length match {
          case 0 => Output.showNoOpenable()
          case 1 => open(openables.head)
          case n if n > 1 => Output.showAmbiguousOpen(openables)
        }
      }
    }
  }
}
