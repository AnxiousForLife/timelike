package game.syntaxEn

import game.syntaxEn.Verb.{Be, Have}

abstract class Verb(lemma: String) extends Lexeme(lemma) with SyntacticCategory {
  def _baseForm: String = lemma //e.g. "drink"
  def _sForm: String = lemma + "s" //e.g. "drinks"
  def _preteriteForm: String //e.g. "drank"
  def _pastParticiple: String //e.g. "drunk"
  def _ingForm: String = { //e.g. "drinking"
    lemma.toList.reverse match {
      case 'e' :: tini => lemma.dropRight(1) ++ "ing" //Verbs that end in "e" ("have" -> "having")
      case 'e' :: 'i' :: tini => lemma.dropRight(2) ++ "ying" //Verbs that end in "ie" ("lie" -> "lying")
      case _ => lemma ++ "ing"
    }
  }

  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, i: Inflection): String = {
    (p, n, i.tense, i.aspect) match {
      case (_, _, Past, Simple) => _preteriteForm //"I/you/he/she/we/they did"
      case (ThirdPerson, Singular, _, Simple) => _sForm //"He/she does"
      case (_, _, _, Simple) => baseForm //"I/you/we/they do"
      case (_, _, _, Progressive) => Be.inflect(p, n, i) ++ " " ++ _ingForm //"_ am/are/was/were/been doing"
      case (_, _, _, Perfect) => Have.inflect(p, n, i) ++ " " ++ _pastParticiple //"_ have/has/had done"
    }
  }

  def baseForm = addSpaces(_baseForm)
  def sForm = addSpaces(_sForm)
  def preteriteForm = addSpaces(_preteriteForm)
  def pastParticiple = addSpaces(_pastParticiple)
  def ingForm = addSpaces(_ingForm)

  def newPrtP(pp: PP) = new PtcP(None, new PtcBarFinal(this, Some(pp)))
}


abstract class WeakVerb(lemma: String) extends Verb(lemma) {
  def _preteriteForm: String = {
    if (lemma.last == 'e') lemma ++ "d"
    else lemma ++ "ed"
  }
  def _pastParticiple: String = preteriteForm
}

object Verb {

  object Be extends Verb("be") {
    override def _sForm: String = "is"
    def _preteriteForm: String = "was"
    def _pastParticiple: String = "been"
    override def _ingForm: String = lemma ++ "ing"

    override def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String = {
      (p, n, a.tense, a.aspect) match {
        case (FirstPerson, Singular, Present, Simple) => "am"
        case (SecondPerson, _, Present, Simple) | (_, Plural, Present, Simple) => "are"
        case (ThirdPerson, Singular, _, Simple) => sForm
        case (SecondPerson, Singular, Past, Simple) | (_, Plural, Past, Simple) => "were"
        case (_, _, Past, Simple) => preteriteForm
        case (_, _, _, Progressive) => Be.inflect(p, n, a) ++ " " ++ ingForm
        case (_, _, _, Perfect) => Have.inflect(p, n, a) ++ " " ++ pastParticiple
      }
    }
  }

  object Engrave extends WeakVerb("engrave")

  object Hang extends Verb("hang") {
    def _preteriteForm: String = "hung"
    def _pastParticiple: String = preteriteForm
  }

  object Have extends Verb("have") {
    override def _sForm: String = "has"
    def _preteriteForm: String = "had"
    def _pastParticiple: String = preteriteForm
  }

  object Lie extends Verb("lie") { //THE INTRANSITIVE ONE
    def _preteriteForm: String = "lay"
    def _pastParticiple: String = "lain"
  }

  object Pull extends WeakVerb("pull")

  object Sit extends Verb("sit") {
    def _preteriteForm: String = "sat"
    def _pastParticiple: String = preteriteForm
    override def _ingForm: String = "sitting"
  }

  object Stand extends Verb("stand") {
    def _preteriteForm: String = "stood"
    def _pastParticiple: String = preteriteForm
  }

  object Write extends Verb("write") {
    def _preteriteForm: String = "wrote"
    def _pastParticiple: String = "written"
  }

  object ZeroVerb extends Verb("") {
    def _preteriteForm: String = ""
    def _pastParticiple: String = ""
  }
}

