package game

import game.syntaxEn.{AdjectivePhrase, PrepositionalPhrase}
import game.syntaxEn.Noun._
import game.syntaxEn.Verb.Sit

abstract class Chest(lock: LockState,
            override val ap: Option[AdjectivePhrase],
            override val pp: Option[PrepositionalPhrase]) extends Container(ChestNoun, ap, pp) {
  override val stativeVerb = Sit
}