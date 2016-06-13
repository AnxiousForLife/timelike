package game

class LockState

object LockState {
  case object Unlocked extends LockState
  case class Barred(symbol: String) extends LockState //Door bars and levers are engraved with matching symbols
  case class KeyLock(key: Key) extends LockState
  case object SwitchLock extends LockState
}

