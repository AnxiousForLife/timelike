package game

import game.syntaxEn.{AdjectivePhrase, SingularNoun, PrepositionalPhrase}
import game.syntaxEn.Determiner._

//Small sandbags, labeled with their integer volume capacity, that can be filled completely, emptied, or poured into
// other bags.
class Sandbag(location: ItemLocation,
              capacity: Int,
              override val ap: Option[AdjectivePhrase],
              override val noun: SingularNoun,
              override val pp: Option[PrepositionalPhrase]) extends Item(location, ap = ap, noun = new SingularNoun("bag"), pp = pp) {
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
