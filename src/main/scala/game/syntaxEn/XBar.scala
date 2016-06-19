package game.syntaxEn

sealed class XBar[T <: Lexeme]

class XBarMedial[T <: Lexeme](xBar: XBar, adjunct: XP) extends XBar[T]
class XBarFinal[T <: Lexeme](head: T, compliment: XP) extends XBar[T]