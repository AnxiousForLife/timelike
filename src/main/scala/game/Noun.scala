package game

import game.util.NumberToWords

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) {
  def withDefinite = "the " ++ lemma
}

class CountableNoun(lemma: String) extends Noun(lemma) {
  def indefiniteArticle = {
    if(lemma.head == ("a", "e", "i", "o", "u")) "an"
    else "a"
  } //DOES NOT account for words like "uniform" which are pronounced with an initial consonant
  def withIndefinite = indefiniteArticle ++ " " ++ lemma
  def plural = lemma ++ "s"
  def withNumber(n: Int) = {
    val numberString = NumberToWords.convert6(n)
    if (n == 1) s"$numberString $lemma"
    else s"$numberString $plural"
  }
}