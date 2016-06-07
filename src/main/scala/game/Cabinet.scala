package game

import game.syntaxEn.{AdjectivePhrase, PrepositionalPhrase}
import game.syntaxEn.Noun._

class Cabinet(override val ap: Option[AdjectivePhrase],
              override val pp: Option[PrepositionalPhrase]) extends Container(CabinetNoun, ap, pp) {
  val top = new Top(this)
}
