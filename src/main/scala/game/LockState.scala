package game

class LockState

object LockState {
  case object Unlocked extends LockState
  case object Barred extends LockState
  case class KeyLock(val key: Key) extends LockState
}

