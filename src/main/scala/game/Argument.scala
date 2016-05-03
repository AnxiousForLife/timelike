package game

import scala.collection.mutable

//Anything that can be the argument of a sentence
class Argument(str: String) extends Printable(str) {
  Argument.update(this)
}

object Argument {
  val list = mutable.Map.empty[String, Argument]

  def update(a: Argument) { list(a.str) = a }

  def lookup(input: String): Argument = list.getOrElse(input, new Argument(input))
}