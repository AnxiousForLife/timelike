package game

import game.util.NumberToWords

//Class for displaying and conjugating noun phrases, with the noun, indefinite article, and optional adjective phrase
class Noun(val noun: String, val art: String, val adj: Option[String]) extends Argument(noun) {
  def withArticle = art ++ " " ++ noun ++ " " ++ adj.getOrElse("")
  def plural = noun ++ "s" ++ " " ++ adj.getOrElse("")
  def withNumber(n: Int) = {
    val numberString = NumberToWords.convert6(n)
    if (n == 1) s"$numberString $noun"
    else s"$numberString $plural"
  }
}