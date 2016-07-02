package game.syntaxEn

trait AdjunctOfDP

class DP(specifier: Option[XP[Determiner]], xBar: DBar) extends XP[Determiner](specifier, xBar) with ComplementOfConjP {
  def nounAgreement: (GrammaticalPerson, GrammaticalNumber) = xBar.nounAgreement

  def and(dp: DP): ConjP = new ConjP(Some(this), new ConjBarFinal(And, Some(dp)))

  def addList(dps: Seq[DP], conj: Conjunction): ConjP = {
    dps match {
      case x :: Nil => new ConjP(Some(this), new ConjBarFinal(conj, Some(x)))
      case x :: xs => new ConjP(Some(this), new ConjBarFinal(conj, Some(addList(xs, conj))))
    }
  }
}

trait DBar extends XBar[Determiner] {
  def nounAgreement: (GrammaticalPerson, GrammaticalNumber)
}
class DBarMedial(xBar: DBar, adjunct: NP) extends XBarMedial[Determiner](adjunct, xBar) with DBar {
  override def toString = adjunctSecond

  def nounAgreement: (GrammaticalPerson, GrammaticalNumber) = xBar.nounAgreement
}
class DBarFinal(head: Determiner, compliment: Option[NP]) extends XBarFinal[Determiner](head, compliment) with DBar {
  override def toString = {
    val complimentString: String = compliment.map(_.decline(head.number)).getOrElse("")
    val detString: String = head match {
      case art: Article if Set('a', 'e', 'i', 'o', 'u').contains(complimentString.trim.head) =>  " an "
      case x => x.toString
    }
    detString ++ complimentString
  }

  def nounAgreement: (GrammaticalPerson, GrammaticalNumber) = (head.person, head.number)
}

object DP {
  def list(dps: Seq[DP], conj: Conjunction): ConjP = dps.head.addList(dps.tail, conj)
}