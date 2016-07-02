package game

import game.PlayerAction.PourBag
import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition.With
import game.syntaxEn.Verb.Write

//Small sandbags, labeled with their integer volume capacity, that can be filled completely, emptied, or poured into
// other bags.
class Sandbag(location: ItemLocation,
              capacity: Int,
              override val noun: CountableNoun)
  extends Item(location, PourBag(None), new CountableNoun("bag")) {

  val relSize = Some(Small)
  val material = Some(Cloth)
  val image = None
  val text = Some(new Writing(capacity.toString))

  var amt: Int = 0

  def remaining = capacity - amt
  def fill() = { amt = capacity }
  def empty() = { amt = 0 }
  def pourInto(bag2: Sandbag) = {
    val diff = amt.min(bag2.remaining)
    amt -= diff
    bag2.amt += diff
  }
}
