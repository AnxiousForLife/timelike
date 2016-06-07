package game.syntaxEn

import game.util.NumberToWords

sealed class Determiner(lemma: String) extends Lexeme(lemma)

object Determiner {
  object A extends Determiner("a")
  object An extends Determiner("an")
  object The extends Determiner("the")
  object Your extends Determiner("your")

  def number(n: Int) = new Determiner(NumberToWords.convert6(n))
}