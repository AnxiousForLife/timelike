package game.engine

import game._
import game.util.ListStrings
import game.util.NumberToOrdinalWords

import scala.collection.mutable

object Output {
  def showInvalid() = println("That means nothing here.")

  def showRoom(state: GameState) = {
    val room = state.room
    s"$room."
  }

  def showDirection(state: GameState): String = {
    val dir = state.direction
    s"You are facing $dir."
  }

  def showWall(state: GameState): String = state.currentWall.showText

  def showRoomObject(state: GameState): String = state.currentWall.roomObject.map(" There's " ++ _.describe ++ ".").getOrElse("")

  //def showItem(state: GameState): String = ListStrings.listAnd(Item.list.filter(x => state.currentWall == x.location).map(x => " There's " ++ x.withArticle ++ " here."))

  //mkString combines the necessary strings, while the optional strings are appended separately.
  def showState(state: GameState) {
    println(Array(showRoom(state), showDirection(state), showWall(state) ++ ".").mkString(" ") ++ showRoomObject(state) /*++ showItem(state)*/)
  }

  def showNotADirection(a: Argument) = {
    println(s""""$a" is not a direction.""")
  }

  def showTurn(rd: RelativeDirection) = {
    println(s"You turn $rd.")
  }

  def showCantOpen(a: Argument) = {
    println(s""""$a" is not a thing that can be opened.""")
  }

  def showNoOpenable() = {
    println(s"There's nothing here to open.")
  }

  //Prints a list of things the player can open if they don't specify what to open.
  def showAmbiguousOpen(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield "the " ++ x.toString()
    val listOr = ListStrings.listOr(stringList)
    println(s"You can open $listOr.")
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

  def showNotSearchable() {
    println("Not something to search.")
  }

  def showDrawer(drawer: Drawer, n: Int) {
    println(s"You look in the ${NumberToOrdinalWords.convert6(n)} drawer." ++ " "/* ++ drawer.show()*/)
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