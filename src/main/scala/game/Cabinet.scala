package game

import game.syntaxEn.Noun._
import game.syntaxEn.Verb.Stand

abstract class Cabinet extends Container(CabinetNoun) {
  override val stativeVerb = Stand
  val top = new Top(this)
  override val locations: Seq[ItemLocation] = Seq(interior, top)
}
