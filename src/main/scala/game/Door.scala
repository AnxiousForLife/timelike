package game

//Connector for two Rooms, which are listed clockwise
class Door(val room1: Room, val room2: Room, var lock: LockState) extends Argument("door")
class AngledDoor(override val room1: Room, override val room2: Room, lock: LockState) extends Door(room1, room2, lock)

object Door extends Argument("door") with Openable