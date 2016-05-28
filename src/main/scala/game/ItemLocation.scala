package game

import game.syntaxEn.{CountableNoun, Preposition}

//Anywhere an Item can be
trait ItemLocation {
  val lPreposition: Option[Preposition]
  val lNoun: Option[CountableNoun]
}

object Inventory extends ItemLocation {
  val lPreposition = None
  val lNoun = None

  def contains(i: Item): Boolean = i.location == this
}