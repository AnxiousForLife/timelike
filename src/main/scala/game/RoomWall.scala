package game

class RoomWall(val showText: String,
               val door: Option[Door],
               val arguments: Option[ConcreteArgument]) extends ItemLocation {
  def availArguments: Seq[Argument] = door.toSeq ++ arguments.toSeq ++ availItems

  def availItems: Seq[Item] = Item.list.filter(x => availLocations.contains(x.location)).toSeq

  def availLocations: Seq[ItemLocation] = {
    val locations = arguments match {
      case Some(c: ItemLocation with Openable) => if(c.state == Opened) Seq[ItemLocation](c) else Seq.empty[ItemLocation]
      case _ => Seq.empty[ItemLocation]
    }
    locations :+ this
  }

  def availOpenables: Seq[Openable] = {
    val openables = {
      arguments match {
        case Some(o: Openable) => Seq[Openable](o)
        case _ => Seq.empty[Openable]
      }
    }
    openables ++ door.toSeq
  }
}