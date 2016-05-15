package game.assets

object RoomWalls {
  import game.assets.Doors._
  import game.assets.Keys._
  import game.Drawer
  import game.RoomObject._
  import game.RoomWall

  object WallTwelve0 extends RoomWall("There's a pair of large, rusted iron doors before you. Between the two handles is embossed the image of a snake eating its tail, with a keyhole for an eye", None, None)
  object WallTwelve1 extends RoomWall("""There's an iron door with a numeral "1" engraved on it""", Some(DoorTwelveOne$), None)
  object WallTwelve2 extends RoomWall("Here's the inner wall", None, None)
  object WallTwelve3 extends RoomWall("""There's an iron door with a numeral "11" engraved on it""", Some(DoorElevenTwelve$), None)

  object WallOne0 extends RoomWall("Here's the outer wall", None, None)
  object WallOne1 extends RoomWall("""There's an iron door with a numeral "2" engraved on it""", Some(DoorwayOneTwo), None)
  object WallOne2 extends RoomWall("Here's the inner wall", None, None)
  object WallOne3 extends RoomWall("""There's an iron door with a numeral "12" engraved on it""", Some(DoorTwelveOne$), None)

  object WallTwo0 extends RoomWall("Here's the outer wall", None, None)
  object WallTwo1 extends RoomWall("""There's an iron door with a numeral "3" engraved on it""", Some(DoorTwoThree$), None)
  object WallTwo2 extends RoomWall("Here's the inner wall", None, None)
  object WallTwo3 extends RoomWall("""There's an iron door with a numeral "1" engraved on it""", Some(DoorwayOneTwo), None)

  object WallThree0 extends RoomWall("Here's the outer wall", None, None)
  object WallThree1 extends RoomWall("""There's an iron door with a numeral "4" engraved on it""", Some(DoorThreeFour$), None)
  object WallThree2 extends RoomWall("Here's the inner wall", None, None)
  object WallThree3 extends RoomWall("""There's an iron door with a numeral "2" engraved on it""", Some(DoorTwoThree$), None)

  object WallFour0 extends RoomWall("Here's the outer wall", None, None)
  object WallFour1 extends RoomWall("""There's an iron door with a numeral "5" engraved on it""", Some(DoorwayFourFive), None)
  object WallFour2 extends RoomWall("Here's the inner wall", None, None)
  object WallFour3 extends RoomWall("""There's an iron door with a numeral "3" engraved on it""", Some(DoorThreeFour$), None)

  object WallFive0 extends RoomWall("Here's the outer wall", None, None)
  object WallFive1 extends RoomWall("""There's an iron door with a numeral "6" engraved on it""", Some(DoorFiveSix$), None)
  object WallFive2 extends RoomWall("Here's the inner wall", None, None)
  object WallFive3 extends RoomWall("""There's an iron door with a numeral "4" engraved on it""", Some(DoorwayFourFive), None)

  object WallSix0 extends RoomWall("Here's the outer wall", None, None)
  object WallSix1 extends RoomWall("""There's an iron door with a numeral "7" engraved on it""", Some(DoorSixSeven$), None)
  object WallSix2 extends RoomWall("Here's the inner wall", None, None)
  object WallSix3 extends RoomWall("""There's an iron door with a numeral "5" engraved on it""", Some(DoorFiveSix$), None)

  object WallSeven0 extends RoomWall("Here's the outer wall", None, None)
  object WallSeven1 extends RoomWall("""There's an iron door with a numeral "8" engraved on it""", Some(DoorwaySevenEight), None)
  object WallSeven2 extends RoomWall("Here's the inner wall", None, None)
  object WallSeven3 extends RoomWall("""There's an iron door with a numeral "6" engraved on it""", Some(DoorSixSeven$), None)

  object WallEight0 extends RoomWall("Here's the outer wall", None, None)
  object WallEight1 extends RoomWall("""There's an iron door with a numeral "9" engraved on it""", Some(DoorEightNine$), None)
  object WallEight2 extends RoomWall("Here's the inner wall", None, None)
  object WallEight3 extends RoomWall("""There's an iron door with a numeral "7" engraved on it""", Some(DoorwaySevenEight), None)

  object WallNine0 extends RoomWall("Here's the outer wall", None, None)
  object WallNine1 extends RoomWall("""There's an iron door with a numeral "10" engraved on it"""", Some(DoorNineTen$), None)
  object WallNine2 extends RoomWall("Here's the inner wall", None, None)
  object WallNine3 extends RoomWall("""There's an iron door with a numeral "8" engraved on it""", Some(DoorEightNine$), None)

  object WallTen0 extends RoomWall("Here's the outer wall", None, None)
  object WallTen1 extends RoomWall("""There's an iron door with a numeral "11" engraved on it"""", Some(DoorwayTenEleven), None)
  object WallTen2 extends RoomWall("Here's the inner wall", None, None)
  object WallTen3 extends RoomWall("""There's an iron door with a numeral "9" engraved on it""", Some(DoorNineTen$), None)

  object WallEleven0 extends RoomWall("Here's the outer wall", None, None)
  object WallEleven1 extends RoomWall("""There's an iron door with a numeral "12" engraved on it"""", Some(DoorElevenTwelve$), None)
  object WallEleven2 extends RoomWall("Here's the inner wall", None, None)
  object WallEleven3 extends RoomWall("""There's an iron door with a numeral "10" engraved on it""", Some(DoorwayTenEleven), None)
}
