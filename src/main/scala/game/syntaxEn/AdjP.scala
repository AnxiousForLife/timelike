package game.syntaxEn

trait AdjunctOfAdjP

class AdjP(specifier: Option[AdvP], xBar: AdjBar) extends XP[Adjective](specifier, xBar) with AdjunctOfNP {
  override def toString = specFirst
}

trait AdjBar extends XBar[Adjective]

class AdjBarFinal(head: Adjective, compliment: Option[PP]) extends XBarFinal[Adjective](head, compliment) with AdjBar {
  override def toString = headFirst
}