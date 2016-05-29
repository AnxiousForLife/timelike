package game.syntaxEn

sealed class Conjunction(lemma:String) extends Lexeme(lemma)

object And extends Conjunction("and")
object Or extends Conjunction("or")