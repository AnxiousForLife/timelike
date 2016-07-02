package game.syntaxEn

class IP(specifier: Option[DP], xBar: IBar) extends XP[Inflection](None, xBar) with ComplementOfCP {
  def nounAgreement: (GrammaticalPerson, GrammaticalNumber) = specifier.map(_.nounAgreement).getOrElse(ThirdPerson, Singular)
  override def toString = xBar.compliment.inflect(nounAgreement._1, nounAgreement._2, xBar.head)
}

class IBar(val head: Inflection, val compliment: VP) extends XBar[Inflection] {
  def getHead = head
}

object IP {
  def newIP(dp: DP, inf: Inflection, vp: VP) = {
    new IP(Some(dp), new IBar(inf, vp))
  }
}
