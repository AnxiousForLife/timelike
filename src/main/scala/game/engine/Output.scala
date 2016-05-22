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

  def showArgument(state: GameState): String = state.currentWall.arguments.map(" There's " ++ _.noun.withIndefinite ++ ".").getOrElse("")

  def showItems(state: GameState): String = {
    state.currentWall.availItems match {
      case Nil => ""
      case items => {
        val stringList: Seq[String] = for (x <- items) yield x.noun.withIndefinite
        " There's " ++ ListStrings.listOr(stringList) ++ " here."
      }
    }
  }

  //mkString combines the necessary strings, while the optional strings are appended separately.
  def showState(state: GameState) {
    println(Array(showRoom(state), showDirection(state), showWall(state) ++ ".").mkString(" ") ++ showArgument(state) ++ showItems(state))
  }

  def showAmbiguousDirection() = {
    println("But which way?")
  }

  def showNotADirection(a: Argument) = {
    println(s""""$a" is not a direction.""")
  }

  def showTurn(rd: RelativeDirection) = {
    println(s"You turn $rd.")
  }

  def showOpen(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} opens.")
  }

  def showAlreadyOpened(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} is already open.")
  }

  def showCantOpen(a: Argument) = {
    println(s""""$a" is not a thing that can be opened.""")
  }

  def showNoOpenable() = {
    println(s"There's nothing here to open.")
  }

  //Prints a list of things the player can open if they don't specify what to open.
  def showAmbiguousOpen(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You can open $listOr.")
  }

  def showNoExit() {
    println("There's no exit here.")
  }

  def showEnterRoom() {
    println("You walk through the doorway.")
  }

  def showDoorClosed() {
    println("The door is closed.")
  }

  def showCantEnter() {
    println("Can't enter that.")
  }

  def showNoItem() {
    println("Nothing here to take.")
  }

  //Prints a list of items the player can take if they don't specify what to take.
  def showAmbiguousTake(items: Seq[Item]) = {
    val stringList: Seq[String] = for (x <- items) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You can take $listOr.")
  }

  def showTakeItem(x: Item) {
    println(s"You take the $x.")
  }

  def showInvalidTake() {
    println(s"Nothing like that here.")
  }

  def showCantTake() {
    println(s"Can't take that.")
  }

  def showCantUnlock() {
    println("Can't unlock that.")
  }

  def showKeyLocked() {
    println("The door is locked.")
  }

  def showDoorBarred() {
    println("The door is blocked by bars.")
  }

  def showUnlock(o: Openable) {
    println(s"You unlock ${o.noun.withDefinite}.")
  }

  def showNoKey() {
    println("You don't have the key to open this.")
  }

  def showCantUnlockBars() {
    println("There's no way to get past the bars.")
  }

  def showAlreadyUnlocked(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} isn't locked.")
  }

  def showNoUnlockable() = {
    println(s"There's nothing here to unlock.")
  }

  def showAmbiguousUnlock(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You can unlock $listOr.")
  }

  def showBlockRewind() {
    println("You can't rewind any further.")
  }

  def showRewind() {
    println("SNAP!")
  }
}