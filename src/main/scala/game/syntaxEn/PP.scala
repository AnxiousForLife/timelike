package game.syntaxEn

import game.syntaxEn.Article.ZeroArticle

trait AdjunctOfPP
//Only a DP may be the complement in a PP, and only PP may be an adjunct in a PP

class PP(specifier: Option[AdjP], xBar: PBar) extends XP[Preposition](specifier, xBar)
  with AdjunctOfAdjP with AdjunctOfNP with AdjunctOfPP with AdjunctOfPtcP with ComplementOfNP {
}

trait PBar extends XBar[Preposition] {
  def addAdjunct(a: XP[_] with AdjunctOfPP) = {
    a match {
      case pp: PP => new PBarPP(this, pp)
    }
  }
}
class PBarPP(xBar: PBar, adjunct: PP) extends XBarMedial[Preposition](adjunct, xBar) with PBar {
  override def toString = adjunctSecond
}
class PBarFinal(head: Preposition, complement: Option[DP]) extends XBarFinal[Preposition](head, complement) with PBar {
  override def toString = headFirst
}
