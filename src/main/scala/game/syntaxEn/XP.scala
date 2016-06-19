package game.syntaxEn

class XP[T <: Lexeme](specifier: XP, xBar: XBar[T]) {
  override def toString = specifier.toString ++ xBar.toString
}

class DP(specifier: XP, xBar: XBar[Determiner]) extends XP(specifier, xBar)