package game

sealed trait ObjectiveState
object Cleared extends ObjectiveState
object Uncleared extends ObjectiveState

class Objective {
  var state: ObjectiveState = Uncleared
  def clear() = state = Cleared
}
