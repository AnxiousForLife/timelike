package game

import game.LockState._
import game.syntaxEn.Adjective.SteelAdj
import game.syntaxEn.SingularNoun
import game.syntaxEn.Verb.Be

sealed class PlateState
object Raised extends PlateState
object Balanced extends PlateState
object Depressed extends PlateState

abstract class PressurePlate(val weight: Int,openable: Openable)
  extends ConcreteArgument(Some(SteelAdj.toAp), new SingularNoun("pressure plate"), None) {
  override val stativeVerb = Be
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
