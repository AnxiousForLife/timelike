package game

object Output {
  def showDirection(state: GameState) = {
    def dir = state.direction
    s"You are facing $dir."
  }
  def showWall(state: GameState) = state.room.currentWall(state.direction).showText

  def showState(state: GameState) = { println(Array(showDirection(state), showWall(state) ++ ".").mkString(" ")) }
}
