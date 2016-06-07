package game.syntaxEn

import game.syntaxEn.Determiner._

class NounPhrase(det: Option[Determiner], ap: Option[AdjectivePhrase], n: Noun, pp: Option[PrepositionalPhrase]) {
  override def toString: String = withDet
  def withDet: String = {
    val getDet: String = det match {
      case Some(A) => {
        rest.head match {
          case ('a' | 'e' | 'i' | 'o' | 'u') => An.toString ++ " "
          case _ => A.toString ++ " "
        }
      }
      case Some(x) => x.toString ++ " "
      case None => ""
    }
    getDet ++ rest
  }
  def rest: String = ap.fold("")(x => x.toString ++ " ") ++ n.toString ++ pp.fold("")(x => " " ++ x.toString)
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