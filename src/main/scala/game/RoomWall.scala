package game

class RoomWall(val showText: String,
               val exit: Option[Door],
               val roomObject: Option[RoomObject]) extends Container