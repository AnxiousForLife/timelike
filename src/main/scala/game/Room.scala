package game

//The game rooms and the direction their outer wall faces
sealed abstract class Room(outwardFace: Direction) {
  val wall0: RoomWall
  val wall1: RoomWall
  val wall2: RoomWall
  val wall3: RoomWall

  val rightFace: Direction = outwardFace.right.right
  val inwardFace: Direction = outwardFace.opposite
  val leftFace: Direction = outwardFace.opposite.right.right

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



final object TestRoom extends Room(North) {
  override val wall0 = new RoomWall("Here's the outer wall")
  override val wall1 = new RoomWall("Here's the right wall")
  override val wall2 = new RoomWall("Here's the inner wall")
  override val wall3 = new RoomWall("Here's the left wall")
}
