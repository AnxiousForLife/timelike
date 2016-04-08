package game

object Output {
  def showDirection(state: GameState) = {
    def dir = state.direction
    s"You are facing $dir."
  }
  def showWall(state: GameState) = state.room.currentWall(state.direction).showText

  def showState(state: GameState) { println(Array(showDirection(state), showWall(state) ++ ".").mkString(" ")) }

  def showNoExit() { println("There's no exit here.") }
  def showEnterRoom() { println("You go through the door.") }
}
