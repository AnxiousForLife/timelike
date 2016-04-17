package game.engine

import game.Drawer
import game.GameState
import game.Item
import game.util.NumberToOrdinalWords

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

  def showRoomObject(state: GameState): String = state.room.currentWall(state.direction).roomObject.map(" There's " ++ _.describe ++ ".").getOrElse("")

  def showItem(state: GameState): String = state.room.currentWall(state.direction).item.map(" There's " ++ _.withArticle ++ " here.").getOrElse("")

  //mkString combines the necessary strings, while the optional strings are appended separately.
  def showState(state: GameState) {
    println(Array(showRoom(state), showDirection(state), showWall(state) ++ ".").mkString(" ") ++ showRoomObject(state) ++ showItem(state))
  }

  def showNoExit() {
    println("There's no exit here.")
  }

  def showEnterRoom() {
    println("You go through the door.")
  }

  def showTakeNothing() {
    println("Nothing here to take.")
  }

  def showTakeItem(x: Item) {
    println(s"You take the $x.")
  }

  def showNoSearch() {
    println("Nothing here to search.")
  }

  def showDrawer(drawer: Drawer, n: Int) {
    println(s"You look in the ${NumberToOrdinalWords.convert6(n)} drawer." ++ " " ++ drawer.show())
  }

  def showKeyLocked() {
    println("The door is locked.")
  }

  def showDoorBarred() {
    println("The door is blocked by bars.")
  }

  def showUnlock() {
    println("You unlock the door.")
  }

  def showBlockRewind() {
    println("You can't rewind any further.")
  }

  def showRewind() {
    println("SNAP!")
  }
}
