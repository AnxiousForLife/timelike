package game.syntaxEn

import game.syntaxEn.Determiner._

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) {
  def toNp = new NounPhrase(None, None, this, None)
  def withDefinite = new NounPhrase(Some(The), None, this, None)
  def toAp = new AdjectivePhrase(None, new Adjective(lemma))
}

class CountableNoun(lemma: String) extends Noun(lemma) {
  def plural = new CountableNoun(lemma ++ "s")

  def withIndefinite = {
    new NounPhrase(Some(A), None, this, None)
  }
}

object Noun {
  object BookcaseNoun extends CountableNoun("bookcase")
  object CabinetNoun extends CountableNoun("cabinet")
  object ChestNoun extends CountableNoun("chest")
  object DoorNoun extends CountableNoun("door")
  object DoorwayNoun extends CountableNoun("doorway")
  object NumeralNoun extends Noun("numeral")
  object PairNoun extends CountableNoun("pair")

  def numeral(n: Int) = new Noun('"' + n.toString + '"')
}