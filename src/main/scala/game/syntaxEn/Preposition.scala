package game.syntaxEn

import game.syntaxEn.Article.ZeroArticle

sealed class Preposition(str: String) extends Lexeme(str) with SyntacticCategory {
  def newPP(dp: DP) = new PP(None, new PBarFinal(this, Some(dp)))
  def newPPWithPron(p: Pronoun) = new PP(None, new PBarFinal(this, Some(p.dp)))
  def newPPWithPlural(noun: Noun) = newPP(ZeroArticle.quickDP(noun))
}

object Preposition {
  object Against extends Preposition("against")
  object Before extends Preposition("before")
  object From extends Preposition("from")
  object In extends Preposition("in")
  object Inside extends Preposition("inside")
  object Of extends Preposition("of")
  object On extends Preposition("on")
  object Through extends Preposition("through")
  object Upon extends Preposition("upon")
  object With extends Preposition("with")
  object ZeroPrep extends Preposition("") {
    override def toString = ""
  }
}