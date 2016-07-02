package game.syntaxEn

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) with SyntacticCategory {
  def newSimpleNBar: NBar = new NBarFinalSimple(this)
  def newSimpleNP: NP = new NP(newSimpleNBar)

  def addFirstAdjunct(a: XP[_] with AdjunctOfNP): NBar = newSimpleNBar.addAdjunct(a)
  def addFirstAdjunctOption(a: Option[XP[_] with AdjunctOfNP]): NBar = newSimpleNBar.addAdjunctOption(a)

  def addAdjuncts(xps: Seq[XP[_] with AdjunctOfNP]): NP = {
    val firstAdjunct = addFirstAdjunct(xps.head)
    xps.tail match {
      case Nil => firstAdjunct.complete
      case xs => firstAdjunct.addAdjuncts(xs)
    }
  }

  def addAdjunctOptions(xps: Seq[Option[XP[_] with AdjunctOfNP]]): NP = {
    val firstAdjunct = addFirstAdjunctOption(xps.head)
    xps.tail match {
      case Nil => firstAdjunct.complete
      case xs => firstAdjunct.addAdjunctOptions(xs)
    }
  }

  def addComplement(a: XP[_] with ComplementOfNP): NBar = {
    a match {
      case np: NP => new NBarFinalNP(Some(np), this)
      case pp: PP => new NBarFinalPP(this, Some(pp))
    }
  }
  def addComplementOption(a: Option[XP[_] with ComplementOfNP]): NBar = {
    a match {
      case None => new NBarFinalSimple(this)
      case Some(np: NP) => new NBarFinalNP(Some(np), this)
      case Some(pp: PP) => new NBarFinalPP(this, Some(pp))
    }
  }

  def decline(number: GrammaticalNumber) = toString
}

class CountableNoun(lemma: String) extends Noun(lemma) {
  def plural = lemma ++ "s"

  override def decline(number: GrammaticalNumber) = {
    number match {
      case Singular => toString
      case Plural => " " ++ plural ++ " "
    }
  }
}

object Noun {
  //B
  object BookcaseNoun extends CountableNoun("bookcase")
  //C
  object CabinetNoun extends CountableNoun("cabinet")
  object ChestNoun extends CountableNoun("chest")
  object CeilingNoun extends CountableNoun("ceiling")
  //D
  object DoorNoun extends CountableNoun("door")
  object DoorwayNoun extends CountableNoun("doorway")
  //F
  object FloorNoun extends CountableNoun("floor")
  //I
  object ImageNoun extends CountableNoun("image")
  //P
  object PairNoun extends CountableNoun("pair")
  object PocketNoun extends CountableNoun("pocket")
  //T
  object TopNoun extends CountableNoun("top")
  //W
  object WallNoun extends CountableNoun("wall")
}