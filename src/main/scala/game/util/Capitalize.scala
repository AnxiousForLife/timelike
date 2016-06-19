package game.util

object Capitalize {
  def eachWord(string: String): String = string.split(' ').map(_.capitalize).mkString(" ")
}
