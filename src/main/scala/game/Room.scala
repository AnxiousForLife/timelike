package game

import game.util.Printable

//The game rooms and the direction their outer wall faces
abstract class Room(str: String, val outwardFace: Direction) extends Printable(str) {
  val wall0: RoomWall
  val wall1: RoomWall
  val wall2: RoomWall
  val wall3: RoomWall

  val rightFace: Direction = outwardFace.right.right
  val inwardFace: Direction = outwardFace.opposite
  val leftFace: Direction = outwardFace.left.left

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