package game

import game.syntaxEn.{AdjectivePhrase, PrepositionalPhrase}
import game.syntaxEn.Noun._
import game.syntaxEn.Verb.Stand

abstract class Cabinet(override val ap: Option[AdjectivePhrase],
              override val pp: Option[PrepositionalPhrase]) extends Container(CabinetNoun, ap, pp) {
  override val stativeVerb = Stand
  val top = new Top(this)
  override val locations: Seq[ItemLocation] = Seq(interior, top)
}
