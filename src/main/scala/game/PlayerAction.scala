package game

sealed abstract class PlayerAction

object PlayerAction {
  case object InvalidAction extends PlayerAction

  case object Quit extends PlayerAction

  case class Turn(arg: Argument) extends PlayerAction

  case object OpenDoor extends PlayerAction
  case class Open(arg: Option[Argument]) extends PlayerAction

  case class TakeItem(arg: Option[Argument]) extends PlayerAction

  case class StartSearch(arg: Option[Argument]) extends PlayerAction
  case object StopSearch extends PlayerAction
  case object NextDrawer extends PlayerAction
  case object PrevDrawer extends PlayerAction

  case object Rewind extends PlayerAction
}
