package game.syntaxEn

trait ComplementOfConjP

class ConjP(specifier: Option[XP[_]], val xBar: ConjBar) extends XP[Conjunction](specifier, xBar) with ComplementOfConjP {
  override def toString = condenseWords(specifier.map(_.medialString).getOrElse("") ++ xBar.toString)
}

trait ConjBar extends XBar[Conjunction]

class ConBarConjP(head: Conjunction, complement: Option[ConjP]) extends XBarFinal[Conjunction](head, complement) with ConjBar {
  override def toString = complement.map(_.xBar.toString).getOrElse("") ++ ", "
}
class ConjBarFinal(head: Conjunction, complement: Option[XP[_]]) extends XBarFinal[Conjunction](head, complement) with ConjBar {
  override def toString = s" $head " ++ complement.map(_.medialString).getOrElse("")
}



