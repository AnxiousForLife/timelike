package game.util

object OptionStrings {
  def concat(s: Seq[Option[String]]): String = s.map(_.getOrElse("")).filter(_.nonEmpty).mkString(" ")
}
