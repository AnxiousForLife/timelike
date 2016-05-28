package game.syntaxEn

import game.Printable

sealed class Preposition(str: String) extends Printable(str)

object On extends Preposition("on")
object In extends Preposition("in")
object From extends Preposition("from")
object Through extends Preposition("through")