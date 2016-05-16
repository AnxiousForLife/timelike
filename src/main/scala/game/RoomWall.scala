package game

class RoomWall(val showText: String,
               val door: Option[Door],
               val roomObject: Option[RoomObject]) extends ItemLocation {
  def availLocations: Seq[ItemLocation] = {
    val roomObjects = roomObject match {
      case Some(c: ItemLocation with Openable) => if(c.state == Opened) Seq[ItemLocation](c) else Seq.empty[ItemLocation]
      case _ => Seq.empty[ItemLocation]
    }
    roomObjects :+ this
  }

  def availArguments: Seq[Argument] = {
    door.toSeq ++ roomObject.toSeq ++ Item.list.filter(x => availLocations.contains(x.location)).toSeq
  }
}