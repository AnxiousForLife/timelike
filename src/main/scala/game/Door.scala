package game

//Connector for two Rooms, which are listed clockwise
class Door(val room1: Room, val room2: Room, var lock: LockState) extends Argument(new Noun("door")) with Openable {
  import PlayerAction._

  override val actions = Map(Open -> open())
}
class AngledDoor(override val room1: Room, override val room2: Room, lock: LockState) extends Door(room1, room2, lock)