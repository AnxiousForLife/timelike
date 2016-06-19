package game

import game.PlayerAction.PourBag
import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition.With

//Small sandbags, labeled with their integer volume capacity, that can be filled completely, emptied, or poured into
// other bags.
class Sandbag(location: ItemLocation,
              capacity: Int,
              override val ap: Option[AdjectivePhrase],
              override val noun: SingularNoun,
              override val pp: Option[PrepositionalPhrase])
  extends Item(location, PourBag(None), ap, new SingularNoun("bag"), pp) {
  override def npIndefinite =
    new SingularNounPhrase(Some(A), ap, noun, Some(
      new PrepositionalPhrase(With, new SingularNounPhrase(
        None, None, new SingularNoun(
          s"""a numeral "$capacity" written on it"""), None)))) //Haven't figured how/too
                                                                //lazy to do participial phrases.

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
