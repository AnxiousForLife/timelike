package game.syntaxEn

import game.Printable

sealed class Preposition(str: String) extends Printable(str)

object Preposition {
  object From extends Preposition("from")
  object In extends Preposition("in")
  object Inside extends Preposition("inside")
  object Of extends Preposition("of")
  object On extends Preposition("on")
  object Through extends Preposition("through")
  object With extends Preposition("with")
}