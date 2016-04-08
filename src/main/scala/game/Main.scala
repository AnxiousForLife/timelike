package game

object Main {
  val state = new GameState(RoomTwelve, North)

  def main(args: Array[String]) {
    var keepRunning = true

    while (keepRunning) {
      Output.showState(state)

      val input = scala.io.StdIn.readLine().toLowerCase
      input match {
        //Quitting the game
        case "quit" => { keepRunning = false }

        //Turning right or left
        case "right" => { state.direction = state.direction.right.right }
        case "left" => { state.direction = state.direction.left.left }

        //Entering a room
        case "forward" | "enter" | "go" => {
          state.room.currentWall(state.direction).nextRoom match {
            case None => { Output.showNoExit() }
            case Some((r, d)) => {
              state.room = r
              state.direction = d
              Output.showEnterRoom()
            }
          }
        }

      }
    }
  }
}