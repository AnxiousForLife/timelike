package game

import game.syntaxEn.{Adjective, Lexeme}

sealed abstract class Quality(str: String) {
  def toLexeme: Lexeme
}

class Material(str: String) extends Quality(str) {
  def toLexeme = new Adjective(str)
}
object Metal extends Material("metal")
object Stone extends Material("stone")
object Wooden extends Material("wooden")