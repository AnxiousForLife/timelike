package game.syntaxEn

import game.Printable

class Complementizer (str: String) extends Printable(str) with SyntacticCategory

object Complementizer {
  object That extends Complementizer("that")
  object ZeroC extends Complementizer("")
}
