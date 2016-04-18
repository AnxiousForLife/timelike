package game

class RoomWall(val showText: String, val exit: Option[Doorway], val roomObject: Option[RoomObject], var item: Option[Seq[Item]])