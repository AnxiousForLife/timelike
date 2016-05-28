package game

import game.syntaxEn.{CountableNoun, In}

object ChestNoun extends CountableNoun("chest")

class Chest(lock: LockState, adj1: Option[String], adj2: Option[String]) extends Openable(ChestNoun, lock, adj1, adj2) with ItemLocation {
  override val lPreposition = Some(In)
  override val lNoun = Some(ChestNoun)
}
