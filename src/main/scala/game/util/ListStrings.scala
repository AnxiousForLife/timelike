package game.util

object ListStrings {
  def list(strings: Seq[String]): String = {
    strings.length match {
      case x if (x <= 1) => strings.headOption.getOrElse("")
      case 2 => strings.head ++ " and " ++ strings.last
      case _ => commaSeparate(strings)
    }
  }

  def commaSeparate(strings: Seq[String]): String = {
    strings match {
      case x::Nil => "and " ++ x
      case x::xs => {
        x ++ ", " ++ commaSeparate(xs)
      }
    }
  }
}
