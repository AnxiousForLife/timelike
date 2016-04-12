package game

object Output {
  def showRoom(state: GameState) = {
    def room = state.room
    s"$room."
  }
  def showDirection(state: GameState) = {
    def dir = state.direction
    s"You are facing $dir."
  }
  def showWall(state: GameState) = state.room.currentWall(state.direction).showText

  def showState(state: GameState) { println(Array(showRoom(state), showDirection(state), showWall(state) ++ ".").mkString(" ")) }

  def showNoExit() { println("There's no exit here.") }
  def showEnterRoom() { println("You go through the door.") }

  def showBlockRewind() { println("You can't go back any further.") }
  def showRewind() { println("SNAP!") }
}
