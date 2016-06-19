package game

import game.syntaxEn._
import game.syntaxEn.Determiner._

//Anything that can be the grammatical argument of a sentence
class Argument(val lexeme: Lexeme) {
  override def toString = lexeme.toString
}

sealed trait Availability
object Available extends Availability
object Unavailable extends Availability

//Any real-world object (referred to by a countable noun) that the player can interact with
abstract class ConcreteArgument(val ap: Option[AdjectivePhrase],
                                val noun: SingularNoun,
                                val pp: Option[PrepositionalPhrase]) extends Argument(noun) {
  override def toString = toNp(Some(The)).toString
  val locationPp: PrepositionalPhrase
  val stativeVerb: Verb

  var availability: Availability = Available
  def isAvailable = availability == Available

  val locations = Seq.empty[ItemLocation]
  def availLocations = locations

  private def simple(det: Option[Determiner]) = new SingularNounPhrase(det, None, noun, None)
  def simpleA = simple(Some(A))
  def simpleThe = simple(Some(The))

  private def toNp(det: Option[Determiner]) = new SingularNounPhrase(det, ap, noun, pp)
  def npIndefinite = toNp(Some(A))
  def npDefinite = toNp(Some(The))

  def show: String = new VerbPhrase(Present, npIndefinite, stativeVerb, locationPp).toString
}

//Used if the player tries to supply an unavailable argument
class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)

//Used if the player tries to supply an ambiguous argument
class AmbiguousArgument(lexeme: Lexeme, args: Seq[Argument]) extends Argument(lexeme)