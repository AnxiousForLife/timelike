package game.syntaxEn

import game.util.NumberToWords

sealed class Determiner(lemma: String) extends Lexeme(lemma)

case object The extends Determiner("the")
case object A extends Determiner("a")
case object An extends Determiner("an")

object Determiner {
  def number(n: Int) = new Determiner(NumberToWords.convert6(n))
}