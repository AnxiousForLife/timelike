package game

import game.PlayerAction.InvalidAction
import game.syntaxEn.Adjective.{LeadAdj, SmallAdj}
import game.syntaxEn.Determiner.A
import game.syntaxEn.Preposition.With
import game.syntaxEn.Verb.Sit
import game.syntaxEn._

class Weight(location: ItemLocation,
             weight: Int)
  extends Item(location, InvalidAction, Some(new ConjoinedAdjectivePhrase(Seq(SmallAdj.toAp, LeadAdj.toAp))), new SingularNoun("weight"), None) {
  override val stativeVerb: Verb = Sit
  override def npIndefinite =
    new SingularNounPhrase(Some(A), ap, noun, Some(
      new PrepositionalPhrase(With, new SingularNounPhrase(
        None, None, new SingularNoun(
          s"""a numeral "$weight" written on it"""), None))))
}
