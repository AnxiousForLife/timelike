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

final case object North extends Direction("north")
final case object NorthEast extends Direction("northeast")
final case object East extends Direction("east")
final case object SouthEast extends Direction("southeast")
final case object South extends Direction("south")
final case object SouthWest extends Direction("southwest")
final case object West extends Direction("west")
final case object NorthWest extends Direction("northwest")