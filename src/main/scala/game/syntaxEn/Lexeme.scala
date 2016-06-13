package game.syntaxEn

import game.Printable

class Lexeme(val lemma: String) extends Printable(lemma)

object DummyLexeme extends Lexeme("")