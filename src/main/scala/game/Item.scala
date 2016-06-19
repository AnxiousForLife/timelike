package game

import game.PlayerAction.Unlock
import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Noun._
import game.syntaxEn.Preposition._
import game.syntaxEn.Pronoun._
import game.syntaxEn.Verb.Lie

class Item(var location: ItemLocation,
           val useAction: PlayerAction,
           override val ap: Option[AdjectivePhrase],
           override val noun: SingularNoun,
           override val pp: Option[PrepositionalPhrase]) extends ConcreteArgument(ap, noun, pp) {
  override val stativeVerb: Verb = Lie
  override val locationPp: PrepositionalPhrase = location.toPp

  def place(l: ItemLocation) = { location = l }
  def take() = place(Inventory)
}

class Key(location: ItemLocation,
          override val ap: Option[AdjectivePhrase],
          override val pp: Option[PrepositionalPhrase])
  extends Item(location, Unlock(None), ap, new SingularNoun("key"), pp)

object Key {
  def numeral(n: Int) =
    new PrepositionalPhrase(With,
      new SingularNounPhrase(Some(A), Some(NumeralNoun.toAp), Noun.numeral(n), Some(new PrepositionalPhrase(On, It.toNp))))
}