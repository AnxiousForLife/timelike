package game

import game.syntaxEn.Noun

trait Balcony

sealed trait Orientation

object OuterFace extends Orientation
object RightFace extends Orientation
object InnerFace extends Orientation
object LeftFace extends Orientation

//The game rooms and the direction their outer wall faces
//(The rooms are arranged in a circle, thus all have one face facing outwards)
abstract class Room(val outwardFace: Direction) extends Argument(new Noun("room")) {
  val description: String

  val wall0: RoomWall
  val wall1: RoomWall
  val wall2: RoomWall
  val wall3: RoomWall

  val objective: Option[Objective] = None

  val rightFace: Direction = outwardFace.right.right
  val inwardFace: Direction = outwardFace.opposite
  val leftFace: Direction = outwardFace.left.left

  def orientations: Map[Direction, Orientation] = Map(outwardFace -> OuterFace,
                                                      rightFace -> RightFace,
                                                      inwardFace -> InnerFace,
                                                      leftFace -> LeftFace)

  def directions: Map[Orientation, Direction] = Map(OuterFace -> outwardFace,
    RightFace -> rightFace,
    InnerFace -> inwardFace,
    LeftFace -> leftFace)

  def currentWall(direction: Direction): RoomWall = {
    direction match {
      case `outwardFace` => wall0
      //90 degrees to the right
      case `rightFace` => wall1
      //180 degrees to the right
      case `inwardFace` => wall2
      //270 degrees to the right
      case `leftFace` => wall3
    }
  }
}