package game

sealed trait OpenState
object Closed extends OpenState
object Opened extends OpenState

//Anything that can be opened
trait Openable {
  import game.LockState._

  var lock: LockState = Unlocked

  var state: OpenState = Closed

  def open() { state = Opened }
  def close() { state = Closed}

  def isOpen = state == Opened

  def unlock() { lock = Unlocked }

  def isUnlocked = lock == Unlocked
}