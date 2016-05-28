package game

import game.syntaxEn.CountableNoun

//Small sandbags, labeled with their integer volume capacity, that can be filled completely, emptied, or poured into
// other bags.
class Sandbag(location: ItemLocation,
              capacity: Int,
              adj1: Option[String],
              adj2: Option[String]) extends Item(new CountableNoun("bag"), adj1, adj2, location) {
  var amt: Int = 0

  def remaining = capacity - amt
  def fill = { amt = capacity }
  def empty = { amt = 0 }
  def pourInto(bag2: Sandbag) = {
    val diff = amt.min(bag2.remaining)
    amt -= diff
    bag2.amt += diff
  }
}
