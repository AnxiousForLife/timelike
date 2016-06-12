package game

import game.syntaxEn.Noun.YouNoun
import game.syntaxEn.Preposition.Before
import game.syntaxEn.Verb.Stand
import game.syntaxEn.{AdjectivePhrase, PrepositionalPhrase, SingularNoun}

class Pedestal(override val ap: Option[AdjectivePhrase],
               override val pp: Option[PrepositionalPhrase]) extends ConcreteArgument(ap, new SingularNoun("pedestal"), pp) with Openable {
  override val stativeVerb = Stand
  override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(Before, YouNoun.toNp)
  val top = new Top(this)
  override val locations = Seq(top)
}
