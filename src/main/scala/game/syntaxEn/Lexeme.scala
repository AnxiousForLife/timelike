package game.syntaxEn

import game.Printable

class Lexeme(val lemma: String) extends Printable(lemma) {
  def addSpaces(str: String) = " " ++ str ++ " "
  override def toString = addSpaces(lemma)
}

object DummyLexeme extends Lexeme("")