package game

import game.syntaxEn._
import game.syntaxEn.Determiner._

//Anything that can be the grammatical argument of a sentence
class Argument(val lexeme: Lexeme) {
  override def toString = lexeme.toString
}

//Any real-world object (referred to by a countable noun) that the player can interact with
abstract class ConcreteArgument(val ap: Option[AdjectivePhrase],
                                val noun: SingularNoun,
                                val pp: Option[PrepositionalPhrase]) extends Argument(noun) {
  val locationPp: PrepositionalPhrase
  val stativeVerb: Verb

  val locations = Seq.empty[ItemLocation]

  def toNp(det: Option[Determiner]) = new SingularNounPhrase(det, ap, noun, pp)
  def npIndefinite = toNp(Some(A))
  def npDefinite = toNp(Some(The))

  def show: String = new VerbPhrase(Present, npIndefinite, stativeVerb, locationPp).toString
}

//Used if the player tries to supply an argument not in the game
class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)