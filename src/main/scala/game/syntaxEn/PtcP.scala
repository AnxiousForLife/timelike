package game.syntaxEn

//"PARTICIPIAL phrase," not "particle phrase" (I can't find how X-Bar theory deals with participial phrases in the literature,
//so I supply a reworked adjective phrase

trait AdjunctOfPtcP

class PtcP(specifier: Option[AdvP], xBar: PtcBar) extends XP[Verb](specifier, xBar) with AdjunctOfNP

trait PtcBar extends XBar[Verb]
class PtcBarFinal(head: Verb, compliment: Option[PP]) extends XBarFinal[Verb](head, compliment) with PtcBar {
  override def toString = head.pastParticiple ++ compliment.map(_.toString).getOrElse("")
}
