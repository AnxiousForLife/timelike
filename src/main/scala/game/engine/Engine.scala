package game.engine

import game._
import game.RoomObject._
import game.LockState._
import game.util.Circular

class Engine(val state: GameState) {

  def getInput() = scala.io.StdIn.readLine().toLowerCase

  //Entering a room
  def enterRoom() = {
    //Is there a door?
    state.currentWall.exit match {
      case None => Output.showNoExit()
      case Some(doorway: Doorway) => {
        val doorWillOpen: Boolean = {
          //Is the door locked?
          doorway.lock match {
            case Unlocked => true
            case Barred => {
              Output.showDoorBarred()
              false
            }
            case keyLock: KeyLock => {
              //Does the player have the right key?
              if (state.inventory.contains(keyLock.key)) {
                doorway.lock = Unlocked
                Output.showUnlock()
                true
              } else {
                Output.showKeyLocked()
                false
              }
            }
          }
        }
        if (doorWillOpen) {
          //Is the player moving clockwise?/Does the player change direction in the next room?
          (state.room.outwardFace == state.direction.left.left, doorway) match {
            case (true, _: AngledDoorway) => {
              state.updateRoom(doorway.room2)
              state.updateDirection(state.direction.right)
            }
            case (false, _: AngledDoorway) => {
              state.updateRoom(doorway.room1)
              state.updateDirection(state.direction.left)
            }
            case (true, _) => state.updateRoom(doorway.room2)
            case (false, _) => state.updateRoom(doorway.room1)
          }
          Output.showEnterRoom()
        }
      }
    }
  }

  /*def takeItem() = {
    val currentWall = state.room.currentWall(state.direction)
    currentWall.item match {
      case None => Output.showTakeNothing()
      case Some(x) => {
        currentWall.item = None
        state.inventory += x
        Output.showTakeItem(x)
      }
    }
  }*/

  //Searching through cabinets ***REDUNDANT "TAKE" METHOD
  def searchLoop() = {
    state.currentWall.roomObject match {
      case Some(cabinet: Cabinet) => {
        var keepRunning = true
        val it = new Circular(cabinet.drawers)

        while (keepRunning) {
          Output.showDrawer(it.current, cabinet.drawers.indexOf(it.current) + 1)
          val input = getInput()
          input match {
            case "exit" => keepRunning = false
            case "next" => it.next
            case "prev" => it.prev
            case "take" => {
              it.current.item match {
                case None => Output.showTakeNothing()
                case Some(x) => {
                  it.current.item = None
                  state.inventory += x
                  Output.showTakeItem(x)
                }
                  true
              }
            }
          }
        }
      }

      case _ => Output.showNoSearch()
    }
  }

  //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
  def rewind() = {
    if (state.log.length > 1) {
      state.lastState
      Output.showRewind()
    } else Output.showBlockRewind()
  }

  def gameLoop() = {
    var keepRunning = true

    while (keepRunning) {
      Output.showState(state)

      val input = getInput()
      input match {
        //Quitting the game
        case "quit" => keepRunning = false

        //Turning right or left
        case "right" => state.updateDirection(state.direction.right.right)
        case "left" => state.updateDirection(state.direction.left.left)

        case "forward" | "enter" | "go" => enterRoom()

        /*case "take" => takeItem()*/

        case "search" => searchLoop()

        case "rewind" => rewind()
      }
    }
  }
}
