package game

import game.syntaxEn._
import game.syntaxEn.Determiner._

//Anything that can be the grammatical argument of a sentence
class Argument(val lexeme: Lexeme) {
  override def toString = lexeme.toString
}

//Any real-world object (referred to by a countable noun) that the player can interact with
class ConcreteArgument(val ap: Option[AdjectivePhrase],
                       val noun: CountableNoun,
                       val pp: Option[PrepositionalPhrase]) extends Argument(noun) {
  def toNp(det: Option[Determiner]) = new NounPhrase(det, ap, noun, pp)
  def npIndefinite = new NounPhrase(Some(A), ap, noun, pp)
  def npDefinite = new NounPhrase(Some(The), ap, noun, pp)

  def show: String = noun.withIndefinite.toString
}

//Used if the player tries to supply an argument not in the game
class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)