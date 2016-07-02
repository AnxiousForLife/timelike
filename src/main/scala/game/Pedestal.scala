package game

import game.syntaxEn.Preposition.Before
import game.syntaxEn.Verb.Stand
import game.syntaxEn.CountableNoun

abstract class Pedestal extends ConcreteArgument(new CountableNoun("pedestal")) with Openable {
  override val stativeVerb = Stand
  //override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(Before, YouNoun.toNp)
  val top = new Top(this)
  override val locations = Seq(top)
}
