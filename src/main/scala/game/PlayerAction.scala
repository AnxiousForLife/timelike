package game

sealed abstract class PlayerAction

object PlayerAction {
  case object InvalidAction extends PlayerAction

  case object Turn extends PlayerAction

  case object Open extends PlayerAction

  case object Enter extends PlayerAction

  case object TakeItem extends PlayerAction
  case object PlaceItem extends PlayerAction

  case object Unlock extends PlayerAction

  case object Rewind extends PlayerAction
}
