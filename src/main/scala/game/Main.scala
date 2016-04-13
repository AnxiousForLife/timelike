package game

object Main {
  def main(args: Array[String]) {
    val startRoom = RoomTwelve
    val startDirection = North
    var state = new GameState(List((startRoom, startDirection)), startRoom, startDirection)

    var keepRunning = true

    while (keepRunning) {
      Output.showState(state)

      val input = scala.io.StdIn.readLine().toLowerCase
      input match {
        //Quitting the game
        case "quit" => keepRunning = false

        //Turning right or left
        case "right" => state = state.updateDirection(state.direction.right.right)
        case "left" => state = state.updateDirection(state.direction.left.left)

        //Entering a room
        case "forward" | "enter" | "go" =>
          state.room.currentWall(state.direction).exit match {
            case None => Output.showNoExit()
            case Some(doorway: Doorway) => {
              //Is the player moving clockwise?/Does the player change direction in the next room?
              (state.room.outwardFace == state.direction.left.left, doorway) match {
                case (true, _: AngledDoorway) => {
                  state = state.updateRoom(doorway.room2)
                  state = state.updateDirection(state.direction.right)
                }
                case (false, _: AngledDoorway) => {
                  state = state.updateRoom(doorway.room1)
                  state = state.updateDirection(state.direction.left)
                }
                case (true, _) => state = state.updateRoom(doorway.room2)
                case (false, _) => state = state.updateRoom(doorway.room1)
              }
              Output.showEnterRoom()
          }
        }

        //Takes the player back to the previous GameState (as long as there are more than 1 previous GameStates)
        case "rewind" =>
          if (state.log.length > 1) {
            state = state.lastState
            Output.showRewind()
          } else Output.showBlockRewind()

      }
    }
  }
}