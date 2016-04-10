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

final object RoomTwelve extends Room(North) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomOne, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomEleven, leftFace.left))
}

final object RoomOne extends Room(NorthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomTwo, rightFace))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomTwelve, leftFace.left))
}

final object RoomTwo extends Room(NorthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomThree, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomOne, leftFace))
}

final object RoomThree extends Room(East) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomFour, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomTwo, leftFace.left))
}

final object RoomFour extends Room(SouthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomFive, rightFace))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomThree, leftFace.left))
}

final object RoomFive extends Room(SouthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomSix, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomFour, leftFace))
}

final object RoomSix extends Room(South) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomSeven, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomFive, leftFace.left))
}

final object RoomSeven extends Room(SouthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomEight, rightFace))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomSix, leftFace.left))
}

final object RoomEight extends Room(SouthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomNine, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomSeven, leftFace))
}

final object RoomNine extends Room(West) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomTen, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomEight, leftFace.left))
}

final object RoomTen extends Room(NorthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomEleven, rightFace))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomNine, leftFace.left))
}

final object RoomEleven extends Room(NorthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(RoomTwelve, rightFace.right))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(RoomTen, leftFace))
}