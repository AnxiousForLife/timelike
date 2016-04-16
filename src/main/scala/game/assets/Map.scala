package game.assets

import game.AngledDoorway
import game.Direction._
import game.Doorway
import game.LockState._
import game.Room
import game.RoomWall

object RoomTwelve extends Room("Room 12", North) {
  override lazy val wall0 = new RoomWall("There's a pair of large, rusted iron doors before you. Between the two handles is embossed the image of a snake eating its tail, with a keyhole for an eye", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "1" engraved on it""", Some(DoorwayTwelveOne), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall("""There's an iron door with a numeral "11" engraved on it""", Some(DoorwayElevenTwelve), None)
}

object RoomOne extends Room("Room 1", NorthEast) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "2" engraved on it""", Some(DoorwayOneTwo), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "12" engraved on it"""", Some(DoorwayTwelveOne), None)
}

object RoomTwo extends Room("Room 2", NorthEast) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "3" engraved on it""", Some(DoorwayTwoThree), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "1" engraved on it"""", Some(DoorwayOneTwo), None)
}

object RoomThree extends Room("Room 3", East) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "4" engraved on it""", Some(DoorwayThreeFour), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "2" engraved on it"""", Some(DoorwayTwoThree), None)
}

object RoomFour extends Room("Room 4", SouthEast) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "5" engraved on it""", Some(DoorwayFourFive), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "3" engraved on it"""", Some(DoorwayThreeFour), None)
}

object RoomFive extends Room("Room 5", SouthEast) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "6" engraved on it""", Some(DoorwayFiveSix), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "4" engraved on it"""", Some(DoorwayFourFive), None)
}

object RoomSix extends Room("Room 6", South) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "7" engraved on it""", Some(DoorwaySixSeven), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "5" engraved on it"""", Some(DoorwayFiveSix), None)
}

object RoomSeven extends Room("Room 7", SouthWest) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "8" engraved on it""", Some(DoorwaySevenEight), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "6" engraved on it"""", Some(DoorwaySixSeven), None)
}

object RoomEight extends Room("Room 8", SouthWest) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "9" engraved on it""", Some(DoorwayEightNine), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "7" engraved on it"""", Some(DoorwaySevenEight), None)
}

object RoomNine extends Room("Room 9", West) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "10" engraved on it"""", Some(DoorwayNineTen), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "8" engraved on it"""", Some(DoorwayEightNine), None)
}

object RoomTen extends Room("Room 10", NorthWest) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "11" engraved on it"""", Some(DoorwayTenEleven), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "9" engraved on it"""", Some(DoorwayNineTen), None)
}

object RoomEleven extends Room("Room 11", NorthWest) {
  override lazy val wall0 = new RoomWall("Here's the outer wall", None, None)
  override lazy val wall1 = new RoomWall("""There's an iron door with a numeral "12" engraved on it"""", Some(DoorwayElevenTwelve), None)
  override lazy val wall2 = new RoomWall("Here's the inner wall", None, None)
  override lazy val wall3 = new RoomWall(""""There's an iron door with a numeral "10" engraved on it"""", Some(DoorwayTenEleven), None)
}

object DoorwayTwelveOne extends AngledDoorway(RoomTwelve, RoomOne, Unlocked)
object DoorwayOneTwo extends Doorway(RoomOne, RoomTwo, Unlocked)
object DoorwayTwoThree extends AngledDoorway(RoomTwo, RoomThree, Unlocked)
object DoorwayThreeFour extends AngledDoorway(RoomThree, RoomFour, Unlocked)
object DoorwayFourFive extends Doorway(RoomFour, RoomFive, Unlocked)
object DoorwayFiveSix extends AngledDoorway(RoomFive, RoomSix, Unlocked)
object DoorwaySixSeven extends AngledDoorway(RoomSix, RoomSeven, Unlocked)
object DoorwaySevenEight extends Doorway(RoomSeven, RoomEight, Unlocked)
object DoorwayEightNine extends AngledDoorway(RoomEight, RoomNine, Unlocked)
object DoorwayNineTen extends AngledDoorway(RoomNine, RoomTen, Unlocked)
object DoorwayTenEleven extends Doorway(RoomTen, RoomEleven, Unlocked)
object DoorwayElevenTwelve extends AngledDoorway(RoomEleven, RoomTwelve, Unlocked)