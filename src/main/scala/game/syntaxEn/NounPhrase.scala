package game.syntaxEn

import game.syntaxEn.Determiner._

abstract class NounPhrase {
  def person: Person
  def number: Number
}

class SingularNounPhrase(det: Option[Determiner], ap: Option[AdjectivePhrase], n: Noun, pp: Option[PrepositionalPhrase])
  extends NounPhrase {
  def person = n.person
  def number = n.number

  override def toString: String = withDet

  def getNoun = n.toNp
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

class ConjoinedNounPhrase(nps: Seq[SingularNounPhrase], conj: Conjunction) extends NounPhrase {
  def person = ThirdPerson
  def number = {
    if (nps.length == 1) Singular else Plural
  }

  override def toString = list(nps, And)

  def list(nps: Seq[SingularNounPhrase], conj: Conjunction): String = {
    val strings: Seq[String] = nps.map(_.toString)
    nps.length match {
      case x if (x <= 1) => strings.headOption.getOrElse("")
      case 2 => strings.head ++ " " ++ conj.toString ++ " " ++ strings.last
      case _ => commaSeparate(strings, conj.toString)
    }
  }

  def commaSeparate(strings: Seq[String], conj: String): String = {
    strings match {
      case x :: Nil => conj ++ " " ++ x
      case x :: xs => {
        x ++ ", " ++ commaSeparate(xs, conj)
      }
    }
  }
}