package game

sealed abstract class PlayerAction(str: String, val input1: Option[LookupResult]) extends Printable(str)
abstract class OneTargetAction(str: String, override val input1: Option[LookupResult]) extends PlayerAction(str, input1)
//abstract class TwoTargetAction(str: String, override val input1: Option[LookupResult], val input2: Option[LookupResult]) extends PlayerAction(str, arg1)


object PlayerAction {
  case object InvalidAction extends PlayerAction("", None)

  case class Examine(override val input1: Option[LookupResult]) extends OneTargetAction("examine", input1)

  case class Turn(override val input1: Option[LookupResult]) extends OneTargetAction("turn", input1)

  case class Open(override val input1: Option[LookupResult]) extends OneTargetAction("open", input1)
  case class Close(override val input1: Option[LookupResult]) extends OneTargetAction("close", input1)

  case class Enter(override val input1: Option[LookupResult]) extends OneTargetAction("enter", input1)

  case class TakeItem(override val input1: Option[LookupResult]) extends OneTargetAction("take", input1)
  case class PlaceItem(override val input1: Option[LookupResult]) extends OneTargetAction("place", input1)

  case class UseItem(override val input1: Option[LookupResult]) extends OneTargetAction("use", input1)

  case class Unlock(override val input1: Option[LookupResult]) extends OneTargetAction("unlock", input1)

  case object CheckMap extends PlayerAction("", None)
  case object CheckCompass extends PlayerAction("", None)

  case class Pull(override val input1: Option[LookupResult]) extends OneTargetAction("pull", input1)

  case class PourBag(override val input1: Option[LookupResult]) extends OneTargetAction("pour", input1)

  case object Rewind extends PlayerAction("", None)
}
