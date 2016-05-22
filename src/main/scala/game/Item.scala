package game

import scala.collection.mutable

class Item(override val noun: CountableNoun, var location: ItemLocation) extends ConcreteArgument(noun) {
  def place(l: ItemLocation) = { location = l }
  def take() = place(Inventory)

  Item.update(this)
}

class Key(location: ItemLocation) extends Item(new CountableNoun("key"), location)

object Item {
  var list = mutable.Set.empty[Item]

  def update(i: Item) { list += i }

  def lookup(input: String): Item = {
    val results = list.filter(_.lexeme.lemma == input)
    assert(results.size <= 1)
    results.head
  }
}