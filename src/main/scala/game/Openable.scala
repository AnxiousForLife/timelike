package game

import game.syntaxEn.CountableNoun

sealed trait OpenState
object Closed extends OpenState
object Opened extends OpenState

//Anything that can be opened
abstract class Openable(noun: CountableNoun,
                        var lock: LockState,
                        override val adj1: Option[String],
                        override val adj2: Option[String]) extends ConcreteArgument(noun, adj1, adj2) {
  import game.LockState._

  var state: OpenState = Closed

  def open() { state = Opened }
  def close() { state = Closed}

  def isOpen = state == Opened

  def unlock() { lock = Unlocked }

  def isUnlocked = lock == Unlocked
}