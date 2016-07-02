package game.syntaxEn

class AdvP(xBar: AdvBarFinal) extends XP[Adverb](None, xBar) {
  override def toString = specFirst
}

class AdvBarFinal(head: Adverb) extends XBarFinal[Adverb](head, None) {
  override def toString = head.toString
}
