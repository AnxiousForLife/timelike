package game

sealed abstract class Direction(str: String) {
  override final def toString() = str

  //The direction to the immediate RIGHT of each direction
  final def right: Direction = this match {
    case North => NorthEast
    case NorthEast => East
    case East => SouthEast
    case SouthEast => South
    case South => SouthWest
    case SouthWest => West
    case West => NorthWest
    case NorthWest => North
  }

  //The direction to the immediate LEFT of each direction
  final def left: Direction = this match {
    case North => NorthWest
    case NorthEast => North
    case East => NorthEast
    case SouthEast => East
    case South => SouthEast
    case SouthWest => South
    case West => SouthWest
    case NorthWest => West
  }

  //The direction BEHIND each direction
  final def opposite: Direction = this match {
    case North => South
    case NorthEast => SouthWest
    case East => West
    case SouthEast => NorthWest
    case South => North
    case SouthWest => NorthEast
    case West => East
    case NorthWest => SouthEast
  }
}

case object North extends Direction("north")
case object NorthEast extends Direction("northeast")
case object East extends Direction("east")
case object SouthEast extends Direction("southeast")
case object South extends Direction("south")
case object SouthWest extends Direction("southwest")
case object West extends Direction("west")
case object NorthWest extends Direction("northwest")