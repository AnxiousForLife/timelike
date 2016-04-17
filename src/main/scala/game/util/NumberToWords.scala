package game.util

object NumberToWords {
  val units = List("one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine")
  val teens = List("ten", "eleven", "twelve", "thirteen",
    "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
  val tens = List("twenty", "thirty", "forty",
    "fifty", "sixty", "seventy", "eighty", "ninety")

  def digit(n: Int, b: Int) = {
    (n / b, n % b)
  }

  def convert2(n: Int): String = {
    val v = digit(n, 10)
    combine2(v._1, v._2)
  }

  def convert3(n: Int) = {
    val v = digit(n, 100)
    combine3(v._1, v._2)
  }

  def convert6(n: Int): String = {
    val v = digit(n, 1000)
    combine6(v._1, v._2)
  }

  def combine2(u: Int, v: Int): String = (u, v) match {
    case (0, v) => units(v - 1)
    case (1, v) => teens(v)
    case (u, 0) => tens(u - 2)
    case (u, v) => tens(u - 2) + "-" + units(v - 1)
  }

  def combine3(u: Int, v: Int) = (u, v) match {
    case (0, v) => convert2(v)
    case (u, 0) => units(u - 1) + " hundred"
    case (u, v) => units(u - 1) + " hundred and " + convert2(v)
  }

  def link(n: Int): String = n < 100 match {
    case true => " and "
    case false => " "
  }

  def combine6(u: Int, v: Int): String = (u, v) match {
    case (0, v) => convert3(v)
    case (u, 0) => convert3(u) + " thousand"
    case (u, v) => convert3(u) + " thousand" + link(v - 1) + convert3(v)
  }
}
