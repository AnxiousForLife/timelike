package game

//The game rooms and the direction their outer wall faces
sealed abstract class Room(val name: String, val outwardFace: Direction) {
  override final def toString() = name

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



object RoomTwelve extends Room("Room 12", North) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayTwelveOne))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayElevenTwelve))
}

object RoomOne extends Room("Room 1", NorthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayOneTwo))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayTwelveOne))
}

object RoomTwo extends Room("Room 2", NorthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayTwoThree))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayOneTwo))
}

object RoomThree extends Room("Room 3", East) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayThreeFour))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayTwoThree))
}

object RoomFour extends Room("Room 4", SouthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayFourFive))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayThreeFour))
}

object RoomFive extends Room("Room 5", SouthEast) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayFiveSix))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayFourFive))
}

object RoomSix extends Room("Room 6", South) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwaySixSeven))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayFiveSix))
}

object RoomSeven extends Room("Room 7", SouthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwaySevenEight))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwaySixSeven))
}

object RoomEight extends Room("Room 8", SouthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayEightNine))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwaySevenEight))
}

object RoomNine extends Room("Room 9", West) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayNineTen))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayEightNine))
}

object RoomTen extends Room("Room 10", NorthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayTenEleven))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayNineTen))
}

object RoomEleven extends Room("Room 11", NorthWest) {
  override val wall0 = new RoomWall("Here's the outer wall", None)
  override val wall1 = new RoomWall("Here's the door leading forward", Some(DoorwayElevenTwelve))
  override val wall2 = new RoomWall("Here's the inner wall", None)
  override val wall3 = new RoomWall("Here's the door leading backward", Some(DoorwayTenEleven))
}