package game

import scala.collection.mutable

//Anything that can be the argument of a sentence
class Argument(val lexeme: Lexeme) {
  val actions = mutable.Map.empty[PlayerAction, () => ()]

  Argument.update(this)
}

class DummyArgument(lexeme: Lexeme) extends Argument(lexeme) { override val actions = Map.empty }

object Argument {
  val list = mutable.Map.empty[String, Argument]

  def update(a: Argument) { list(a.lexeme.lemma) = a }

  def lookup(input: String): Argument = list.getOrElse(input, new DummyArgument(new Lexeme(input)))
}

class Cabinet extends Openable(new CountableNoun("cabinet")) with ItemLocation