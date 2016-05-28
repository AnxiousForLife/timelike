package game

sealed abstract class PlayerAction(str: String) extends Printable(str)

object PlayerAction {
  case object InvalidAction extends PlayerAction("")

  case class Examine(arg: Option[Argument]) extends PlayerAction("examine")

  case class Turn(arg: Option[Argument]) extends PlayerAction("turn")

  case class Open(arg: Option[Argument]) extends PlayerAction("open")
  case class Close(arg: Option[Argument]) extends PlayerAction("close")

  case class Enter(arg: Option[Argument]) extends PlayerAction("enter")

  case class TakeItem(arg: Option[Argument]) extends PlayerAction("take")
  case class PlaceItem(arg1: Option[Argument], arg2: Option[Argument]) extends PlayerAction("place")

  case class Unlock(arg: Option[Argument]) extends PlayerAction("unlock")

  case class Pull(arg: Option[Argument]) extends PlayerAction("pull")

  case class PourBag(arg1: Option[Argument], arg2: Option[Argument]) extends PlayerAction("pour")

  case object Rewind extends PlayerAction("")
}
