package game.syntaxEn

import game.syntaxEn.Determiner._
import game.util.ListStrings

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

  override def toString = ListStrings.list(nps.map(_.toString), conj.toString)
}