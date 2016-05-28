package game

import game.LockState.{Barred, Unlocked}
import game.syntaxEn.CountableNoun

sealed trait LeverState

object LeverState {
  object Up extends LeverState
  object Down extends LeverState
}

class Lever(var state: LeverState,
            val symbol: String,
            door1: Door,
            door2: Door) extends ConcreteArgument(new CountableNoun("lever"), None, None) {
  import game.LeverState._

  def pull() = {
    state match {
      case Up => state = Down
      case Down => state = Up
    }
    update()
  }

  def update() = {
    state match {
      case Up => door1.lock = Unlocked; door2.lock = Barred
      case Down => door1.lock = Barred; door2.lock = Unlocked
    }
  }

  update()
}
