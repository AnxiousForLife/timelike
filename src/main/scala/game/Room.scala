package game

import game.syntaxEn.Noun

trait Balcony

sealed trait Orientation

object OuterFace extends Orientation
object RightFace extends Orientation
object InnerFace extends Orientation
object LeftFace extends Orientation

//The game rooms and the direction their outer wall faces
//(The rooms are arranged in a circle, thus are defined by the direction their outward face points)
abstract class Room(val outwardDirection: Direction, val name: String) extends Argument(new Noun("room")) {
  val description: String

  val wall0: RoomWall
  val wall1: RoomWall
  val wall2: RoomWall
  val wall3: RoomWall

  val rightDirection: Direction = outwardDirection.right.right
  val inwardDirection: Direction = outwardDirection.opposite
  val leftDirection: Direction = outwardDirection.left.left

  def orientations: Map[Direction, Orientation] = Map(outwardDirection -> OuterFace,
                                                      rightDirection -> RightFace,
                                                      inwardDirection -> InnerFace,
                                                      leftDirection -> LeftFace)

  def directions: Map[Orientation, Direction] = Map(OuterFace -> outwardDirection,
    RightFace -> rightDirection,
    InnerFace -> inwardDirection,
    LeftFace -> leftDirection)

  def currentWall(direction: Direction): RoomWall = {
    direction match {
      case `outwardDirection` => wall0
      //90 degrees to the right
      case `rightDirection` => wall1
      //180 degrees to the right
      case `inwardDirection` => wall2
      //270 degrees to the right
      case `leftDirection` => wall3
    }
  }
}