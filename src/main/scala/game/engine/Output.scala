package game.engine

import game.GameState
import game.Item

object Output {
  def showRoom(state: GameState) = {
    val room = state.room
    s"$room."
  }
  def showDirection(state: GameState): String = {
    val dir = state.direction
    s"You are facing $dir."
  }
  def showWall(state: GameState): String = state.room.currentWall(state.direction).showText
  def showItem(state: GameState): String = {
    state.room.currentWall(state.direction).item match {
      case None => ""
      case Some(x) => s"There's $x."
    }
  }
  def showState(state: GameState) { println(Array(showRoom(state), showDirection(state), showWall(state) ++ ".", showItem(state)).mkString(" ")) }

  def showNoExit() { println("There's no exit here.") }
  def showEnterRoom() { println("You go through the door.") }

  def showTakeNothing() { println("There's nothing here to take.") }
  def showTakeItem(x: Item) { println(s"You take the $x.")}

  def showKeyLocked() { println("The door is locked.") }
  def showDoorBarred() { println("The door is blocked by bars.") }
  def showUnlock() { println("You unlock the door.") }

  def showBlockRewind() { println("You can't rewind any further.") }
  def showRewind() { println("SNAP!") }
}
