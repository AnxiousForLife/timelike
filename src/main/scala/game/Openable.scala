package game

sealed trait OpenState
object Closed extends OpenState
object Opened extends OpenState

//Anything that can be opened
abstract class Openable(noun: CountableNoun, var lock: LockState ) extends ConcreteArgument(noun) {
  import game.LockState._

  var state: OpenState = Closed

  def open() { state = Opened }
  def close() { state = Closed}

  def isOpen = state == Opened

  def unlock() { lock = Unlocked }

  def isUnlocked = lock == Unlocked
}