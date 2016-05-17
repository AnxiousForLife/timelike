package game

class RoomWall(val showText: String,
               val door: Option[Door],
               val arguments: Option[Argument]) extends ItemLocation {
  def availLocations: Seq[ItemLocation] = {
    val locations = arguments match {
      case Some(c: ItemLocation with Openable) => if(c.state == Opened) Seq[ItemLocation](c) else Seq.empty[ItemLocation]
      case _ => Seq.empty[ItemLocation]
    }
    locations :+ this
  }

  def availArguments: Seq[Argument] = {
    door.toSeq ++ arguments.toSeq ++ Item.list.filter(x => availLocations.contains(x.location)).toSeq
  }
}