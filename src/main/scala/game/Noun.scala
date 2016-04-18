package game

import game.util.NumberToWords

//Class for displaying and conjugating noun phrases, with the noun, indefinite article, and optional adjective phrase
class Noun(str: String, art: String, ap: Option[String]) extends Printable(str) {
  def withArticle = art ++ " " ++ str ++ " " ++ ap.getOrElse("")
  def plural = str ++ "s" ++ " " ++ ap.getOrElse("")
  def withNumber(n: Int) = {
    val numberString = NumberToWords.convert6(n)
    if (n == 1) s"$numberString $str"
    else s"$numberString $plural"
  }
}