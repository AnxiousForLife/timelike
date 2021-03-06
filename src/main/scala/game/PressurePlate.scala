package game

import game.LockState._
import game.syntaxEn.SingularNoun

sealed class PlateState
object Raised extends PlateState
object Balanced extends PlateState
object Depressed extends PlateState

abstract class PressurePlate(weight: Int, openable: Openable) extends ConcreteArgument(None, new SingularNoun("pressure plate"), None) {
  val top = new Top(this)
  override val locations = Seq(top)

  var state: PlateState

  def update() = {
    state match {
      case Raised => openable.lock = SwitchLock
      case Balanced => openable.lock = Unlocked
      case Depressed => openable.lock = SwitchLock
    }
  }
}
