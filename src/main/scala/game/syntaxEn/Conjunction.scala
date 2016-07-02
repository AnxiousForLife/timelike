package game.syntaxEn

sealed class Conjunction(lemma:String) extends Lexeme(lemma) with SyntacticCategory

object And extends Conjunction("and")
object Or extends Conjunction("or")