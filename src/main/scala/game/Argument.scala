package game

import game.syntaxEn.Article.{A, The}
import game.syntaxEn._

//Anything that can be the grammatical argument of a sentence
class Argument(val lexeme: Lexeme)

sealed trait Availability
object Available extends Availability
object Unavailable extends Availability

//Any real-world object the player can interact with
abstract class ConcreteArgument(val noun: CountableNoun) extends Argument(noun) {
  //What it is
  val relSize: Option[RelativeSize]
  val material: Option[Material]
  val image: Option[Image]
  val text: Option[Text]

  var availability: Availability = Available
  val locations = Seq.empty[ItemLocation]

  //val locationPp: PrepositionalPhrase
  val stativeVerb: Verb

  //val prototype: AttributeList

  def attributes: Seq[Option[ObjectAttribute]] = Seq(relSize, material, image, text) //Elements are to remain in this order

  def uniqueAttributes(attrsAreDifferent: Seq[Boolean]): Seq[Option[ObjectAttribute]] = {
    for ((x, i) <- attrsAreDifferent.zipWithIndex) yield {
      if (x)
        attributes(i)
      else
        None
    }
  }

  def isAvailable = availability == Available
  def availLocations = locations

  def describe(xps: Seq[Option[XP[_] with AdjunctOfNP]]): NP = noun.addAdjunctOptions(xps.reverse)

  //The phrase used to introduce the object to the player, of the form "a (`size`), `material` `noun` (`text`)."
  def introduceDP: DP = A.newDP(describe(for (x <- attributes) yield x.map(_.xp)))
  //The phrase used to quickly reference the object
  def referenceDP: DP = The.quickDP(noun)
}

//Used if the player tries to supply an unavailable argument
class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)

//Used if the player tries to supply an ambiguous argument
class AmbiguousArgument(lexeme: Lexeme, args: Seq[Argument]) extends Argument(lexeme)

object Argument {
  def attrsAreDifferent(args: Seq[ConcreteArgument]): Seq[Boolean] = {
    val attrs = (for (x <- args) yield x.attributes).transpose
    for (x <- attrs) yield {
      if (x.distinct.length <= 1)
        false
      else
        true
    }
  }

  def distinguishArgs(args: Seq[ConcreteArgument], conj: Conjunction): ConjP = {
    val dps: Seq[DP] = for (x <- args) yield The.newDP(x.describe(for (y <- x.uniqueAttributes(attrsAreDifferent(args))) yield y.map(_.xp)))
    DP.list(dps, conj)
  }
}