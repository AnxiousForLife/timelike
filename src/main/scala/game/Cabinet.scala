package game

import game.syntaxEn.{CountableNoun, In}

object CabinetNoun extends CountableNoun("cabinet")

class Cabinet(lock: LockState,
              override val adj1: Option[String],
              override val adj2: Option[String]) extends Openable(CabinetNoun, lock, adj1, adj2) with ItemLocation {
  override val lPreposition = Some(In)
  override val lNoun = Some(CabinetNoun)
}
