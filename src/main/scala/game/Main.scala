package game

object Main {
  val state = new GameState(TestRoom, North)

  def main(args: Array[String]) {
    var keepRunning = true

    while (keepRunning) {
      Output.showState(state)

      val input = scala.io.StdIn.readLine().toLowerCase
      input match {
        case "quit" => { keepRunning = false }
        case "right" => { state.direction = state.direction.right.right }
        case "left" => { state.direction = state.direction.left.left }
      }
    }
  }
}