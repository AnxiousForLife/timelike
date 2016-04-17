package game.util

class Noun(str: String, art: String) extends Printable(str) {
  def withArticle = art + " " + str
  def plural = str + "s"
  def withNumber(n: Int) = {
    val numberString = NumberToWords.convert6(n)
    if (n == 1) s"$numberString $str"
    else s"$numberString $plural"
  }
}