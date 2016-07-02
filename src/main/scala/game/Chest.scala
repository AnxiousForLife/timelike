package game

import game.syntaxEn.Noun._
import game.syntaxEn.Verb.Sit

abstract class Chest(lock: LockState) extends Container(ChestNoun) {
  val material = Some(Wooden)
  val image = None
  val text = None

  override val stativeVerb = Sit
}