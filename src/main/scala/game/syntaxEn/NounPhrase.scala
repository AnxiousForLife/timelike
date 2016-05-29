package game.syntaxEn

class NounPhrase(det: Option[Determiner], ap: Option[AdjectivePhrase], n: Noun, pp: Option[PrepositionalPhrase]) {
  override def toString: String =
    det.fold("")(x => x.toString ++ " ") ++ ap.fold("")(x => x.toString ++ " ") ++ n.toString ++ pp.fold("")(x => " " ++ x.toString)
}

class ConjoinedNounPhrase(nps: Seq[NounPhrase], conj: Conjunction) {
  override def toString = list(nps, And)

  def list(nps: Seq[NounPhrase], conj: Conjunction): String = {
    val strings: Seq[String] = nps.map(_.toString)
    nps.length match {
      case x if (x <= 1) => strings.headOption.getOrElse("")
      case 2 => strings.head ++ " " ++ conj.toString ++ " " ++ strings.last
      case _ => commaSeparate(strings, conj.toString)
    }
  }

  def commaSeparate(strings: Seq[String], conj: String): String = {
    strings match {
      case x::Nil => conj ++ " " ++ x
      case x::xs => {
        x ++ ", " ++ commaSeparate(xs, conj)
      }
    }
  }
}