package game

import game.LockState.{Barred, Unlocked}
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition.{On, With}
import game.syntaxEn.Pronoun.It
import game.syntaxEn.{CountableNoun, NounPhrase, PrepositionalPhrase}

sealed trait LeverState

object LeverState {
  object Up extends LeverState
  object Down extends LeverState
}

class Lever(var state: LeverState,
            val symbol: String, //Levers and door bars are engraved with matching symbols
            door1: Door,
            door2: Door) extends ConcreteArgument(None, new CountableNoun("lever"), None) {
  import game.LeverState._

  override def show =
    new NounPhrase(Some(A), ap, noun, None).toString ++
      s" with the image of ${new CountableNoun(symbol).plural} engraved on it" //Haven't figured out and/or too lazy
                                                                                //to do prepositional phrases.

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
