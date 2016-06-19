package game.syntaxEn

import game.syntaxEn.Determiner._

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) {
  val number = Singular
  val person = ThirdPerson

  def toNp = new SingularNounPhrase(None, None, this, None)
  def withDefinite = new SingularNounPhrase(Some(The), None, this, None)
  def toAp = new SimpleAdjectivePhrase(new Adjective(lemma))
}

class SingularNoun(lemma: String) extends Noun(lemma) {
  def plural = new SingularNoun(lemma ++ "s")

  def withIndefinite = {
    new SingularNounPhrase(Some(A), None, this, None)
  }
}

class PluralNoun(lemma: String) extends Noun(lemma) {
  override val number = Plural
}

object Noun {
  object BookcaseNoun extends SingularNoun("bookcase")
  object CabinetNoun extends SingularNoun("cabinet")
  object ChestNoun extends SingularNoun("chest")
  object CeilingNoun extends SingularNoun("ceiling")
  object DoorNoun extends SingularNoun("door")
  object DoorwayNoun extends SingularNoun("doorway")
  object FloorNoun extends SingularNoun("floor")
  object NumeralNoun extends Noun("numeral")
  object PairNoun extends SingularNoun("pair")
  object WallNoun extends SingularNoun("wall")
  object YouNoun extends Noun("you") //FOR NOW; pronouns aren't their own class

  def numeral(n: Int) = new Noun('"' + n.toString + '"')
}