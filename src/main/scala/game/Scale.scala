package game

import game.LockState._
import game.syntaxEn.Adjective.SteelAdj
import game.syntaxEn.Noun.CeilingNoun
import game.syntaxEn.Preposition.From
import game.syntaxEn.{PrepositionalPhrase, SingularNoun}
import game.syntaxEn.Verb.Hang

sealed class PlateState
object Raised extends PlateState
object Balanced extends PlateState
object Depressed extends PlateState

abstract class Scale(val weight: Int, val openable: Openable, unlockConfig: PlateState)
  extends ConcreteArgument(None, new SingularNoun("weighing scale"), None) {
  override val stativeVerb = Hang
  override val locationPp = new PrepositionalPhrase(From, CeilingNoun.withDefinite)
  val top = new Top(this)

  override val locations = Seq(top)

  var state: PlateState = Raised

  def update() = {
    state match {
      case Raised => openable.lock = SwitchLock
      case Balanced => openable.lock = Unlocked
      case Depressed => openable.lock = SwitchLock
    }
  }
}
