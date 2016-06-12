package game

import game.LockState.{Barred, Unlocked}
import game.syntaxEn.Determiner._
import game.syntaxEn.Noun.CeilingNoun
import game.syntaxEn.Preposition.{From, With}
import game.syntaxEn.Verb.{Hang, Pull}
import game.syntaxEn.{SingularNounPhrase, PrepositionalPhrase, SingularNoun}

sealed trait LeverState

object LeverState {
  object Up extends LeverState
  object Down extends LeverState
}

class PullChain(var state: LeverState,
                val symbol: String, //Levers and door bars are engraved with matching symbols
                door1: Door,
                door2: Door) extends ConcreteArgument(Some(Pull.toAp), new SingularNoun("chain"), None) {
  import game.LeverState._
  override val stativeVerb = Hang
  override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(From, CeilingNoun.withDefinite)

  override def npIndefinite =
    new SingularNounPhrase(Some(A), ap, noun, Some(
      new PrepositionalPhrase(With, new SingularNounPhrase(
        None, None, new SingularNoun(
          s"the image of ${new SingularNoun(symbol).plural} engraved on the handle"), None)))) //Haven't figured how/too
                                                                                               //lazy to do participial phrases.

  def pull() = {
    state match {
      case Up => state = Down
      case Down => state = Up
    }
    update()
  }

  def update() = {
    state match {
      case Up => door1.lock = Unlocked; door2.lock = bars
      case Down => door1.lock = bars; door2.lock = Unlocked
    }
  }

  val bars = new Barred(symbol)

  update()
}
