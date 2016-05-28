package game

import game.syntaxEn.CountableNoun

import scala.collection.mutable

class Item(override val noun: CountableNoun,
           override val adj1: Option[String],
           override val adj2: Option[String],
           var location: ItemLocation) extends ConcreteArgument(noun, adj1, adj2) {
  def place(l: ItemLocation) = { location = l }
  def take() = place(Inventory)

  Item.update(this)
}

class Key(location: ItemLocation, adj1: Option[String], adj2: Option[String]) extends Item(new CountableNoun("key"), adj1, adj2, location)

object Item {
  var list = mutable.Set.empty[Item]

  def update(i: Item) { list += i }

  def lookup(input: String): Item = {
    val results = list.filter(_.lexeme.lemma == input)
    assert(results.size <= 1)
    results.head
  }
}