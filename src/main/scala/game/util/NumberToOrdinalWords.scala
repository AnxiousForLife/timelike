package game.util

object NumberToOrdinalWords {
  val ordUnits = List("first", "second", "third", "fourth",
    "fifth", "sixth", "seventh", "eighth", "ninth")
  val ordTeens = List("tenth", "eleventh", "twelfth", "thirteenth",
    "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth")
  val ordTens = List("twentieth", "thirtieth", "fortieth",
    "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth")

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
    case (0, v) => ordUnits(v - 1)
    case (1, v) => ordTeens(v)
    case (u, 0) => ordTens(u - 2)
    case (u, v) => ordTens(u - 2) + "-" + ordUnits(v - 1)
  }

  def combine3(u: Int, v: Int) = (u, v) match {
    case (0, v) => convert2(v)
    case (u, 0) => ordUnits(u - 1) + " hundredth"
    case (u, v) => ordUnits(u - 1) + " hundred and " + convert2(v)
  }

  def link(n: Int): String = n < 100 match {
    case true => " and "
    case false => " "
  }

  def combine6(u: Int, v: Int): String = (u, v) match {
    case (0, v) => convert3(v)
    case (u, 0) => convert3(u) + " thousandth"
    case (u, v) => convert3(u) + " thousand" + link(v - 1) + convert3(v)
  }
}
