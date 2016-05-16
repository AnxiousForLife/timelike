package game

import scala.collection.mutable

class Item(override val noun: String,
           override val art: String,
           override val adj: Option[String],
           var location: ItemLocation) extends Noun(noun, art, adj) {
  Item.update(this)
}

class Key(override val noun: String,
          override val art: String,
          override val adj: Option[String],
          location: ItemLocation) extends Item(noun, art, adj, location)

object Item {
  var list = mutable.Set.empty[Item]

  def update(i: Item) { list += i }

  def lookup(input: String): Item = {
    val results = list.filter(_.str == input)
    assert(results.size <= 1)
    results.head
  }
}