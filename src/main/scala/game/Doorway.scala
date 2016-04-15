package game

//Connector for two Rooms, which are listed clockwise
class Doorway(val room1: Room, val room2: Room, var lock: LockState)
class AngledDoorway(override val room1: Room, override val room2: Room, lock: LockState) extends Doorway(room1, room2, lock)