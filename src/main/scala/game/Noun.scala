package game

import game.util.NumberToWords

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) {
  def article = {
    if(lemma.head == ("a", "e", "i", "o", "u")) "an"
    else "a"
  }
  def withArticle = article ++ " " ++ lemma
  def plural = lemma ++ "s"
  def withNumber(n: Int) = {
    val numberString = NumberToWords.convert6(n)
    if (n == 1) s"$numberString $lemma"
    else s"$numberString $plural"
  }
}