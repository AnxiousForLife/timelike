package game

import game.syntaxEn.Noun.WallNoun
import game.syntaxEn.Preposition.Against
import game.syntaxEn.{AdjectivePhrase, PrepositionalPhrase, SingularNoun}

abstract class Container(override val noun: SingularNoun,
                override val ap: Option[AdjectivePhrase],
                override val pp: Option[PrepositionalPhrase]) extends ConcreteArgument(ap, noun, pp) with Openable {
  override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(Against, WallNoun.withDefinite)

  val interior = new Interior(this)

  override val locations: Seq[ItemLocation] = Seq(interior)
}