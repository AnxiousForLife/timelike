package game

import scala.collection.mutable

//Anything that can be the argument of a sentence
class Argument(val lexeme: Lexeme) {
  val actions = mutable.Map.empty[PlayerAction, (Any) => (Any)]

  override def toString = lexeme.lemma

  Argument.update(this)
}

class DummyArgument(lexeme: Lexeme) extends Argument(lexeme)

object Argument {
  val map = mutable.Map.empty[String, Argument]

  def update(a: Argument) { map(a.lexeme.lemma) = a }

  def lookup(input: String): Argument = map.getOrElse(input, new DummyArgument(new Lexeme(input)))

  update(RelativeDirection.Left)
  update(RelativeDirection.Right)
}

class ConcreteArgument(val noun: CountableNoun) extends Argument(noun)

class Cabinet(lock: LockState) extends Openable(new CountableNoun("cabinet"), lock) with ItemLocation