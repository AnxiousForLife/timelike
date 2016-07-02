package game

import game.LockState._
import game.syntaxEn.Adjective.SteelAdj
import game.syntaxEn.Noun.CeilingNoun
import game.syntaxEn.Preposition.From
import game.syntaxEn.CountableNoun
import game.syntaxEn.Verb.Hang

sealed class ScaleState
object Raised extends ScaleState
object Balanced extends ScaleState
object Depressed extends ScaleState

class Scale(val weight: Int, val openable: Openable, unlockConfig: ScaleState)
  extends ConcreteArgument(new CountableNoun("weighing scale")) {

  val relSize = Some(Small)
  val material = Some(Metal)
  val image = None
  val text = None

  override val stativeVerb = Hang
  //override val locationPp = new PrepositionalPhrase(From, CeilingNoun.withDefinite)
  val top = new Top(this)

  override val locations = Seq(top)

  var state: ScaleState = Raised

  def update() = {
    state match {
      case Raised => openable.lock = SwitchLock
      case Balanced => openable.lock = Unlocked
      case Depressed => openable.lock = SwitchLock
    }
  }
}
