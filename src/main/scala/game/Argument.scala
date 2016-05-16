package game

import scala.collection.mutable

//Anything that can be the argument of a sentence
abstract class Argument(str: String) extends Printable(str) {
  Argument.update(this)

  val actions: Map[PlayerAction, () => ()]
}

class DummyArgument(str: String) extends Argument(str)

object Argument {
  val list = mutable.Map.empty[String, Argument]

  def update(a: Argument) { list(a.str) = a }

  def lookup(input: String): Argument = list.getOrElse(input, new DummyArgument(input))
}