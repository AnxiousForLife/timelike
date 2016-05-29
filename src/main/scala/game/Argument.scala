package game

import game.syntaxEn.{AdjectivePhrase, CountableNoun, Lexeme, PrepositionalPhrase}

//Anything that can be the grammatical argument of a sentence
class Argument(val lexeme: Lexeme) {
  override def toString = lexeme.toString
}

//Any real-world object (referred to by a countable noun) that the player can interact with
class ConcreteArgument(val noun: CountableNoun,
                       val ap: Option[AdjectivePhrase],
                       val pp: Option[PrepositionalPhrase]) extends Argument(noun) {
  def
}

//Used if the player tries to supply an argument not in the game
class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)