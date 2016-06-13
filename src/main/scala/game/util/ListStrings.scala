package game.util

object ListStrings {
  private val and = "and"
  private val or = "or"

  def list(strings: Seq[String], conj: String): String = {
    strings.length match {
      case x if (x <= 1) => strings.headOption.getOrElse("")
      case 2 => strings.head ++ " " ++ conj ++ " " ++ strings.last
      case _ => commaSeparate(strings, conj)
    }
  }

  def commaSeparate(strings: Seq[String], conj: String): String = {
    strings match {
      case x :: Nil => conj ++ " " ++ x
      case x :: xs => x ++ ", " ++ commaSeparate(xs, conj)
    }
  }

  def listAnd(strings: Seq[String]): String = list(strings, and)

  def listOr(strings: Seq[String]): String = list(strings, or)
}
