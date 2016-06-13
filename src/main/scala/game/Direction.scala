package game

import game.syntaxEn.{Lexeme, Noun}

sealed abstract class Direction(str: String) extends Printable(str) {
  import Direction._
  import RelativeDirection._

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

  def turn(rDir: RelativeDirection) = {
    rDir match {
      case Left => this.left.left
      case Right => this.right.right
    }
  }
}

object Direction {
  case object North extends Direction("north")
  case object NorthEast extends Direction("northeast")
  case object East extends Direction("east")
  case object SouthEast extends Direction("southeast")
  case object South extends Direction("south")
  case object SouthWest extends Direction("southwest")
  case object West extends Direction("west")
  case object NorthWest extends Direction("northwest")
}

sealed abstract class RelativeDirection(val noun: Noun) extends Argument(noun)

object RelativeDirection {
  case object Left extends RelativeDirection(new Noun("left"))
  case object Right extends RelativeDirection(new Noun("right"))
}