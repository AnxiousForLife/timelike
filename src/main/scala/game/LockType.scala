package game

sealed class LockType

object Barred extends LockType
class KeyLock(val key: Key) extends LockType
