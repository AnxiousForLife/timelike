package game.assets

//Walls are listed starting with the outer wall, then going clockwise
object RoomWalls {
  import game.assets.Doors._
  import game.assets.Cabinets._
  import game.assets.Levers._
  import game.RoomWall

  object WallTwelve0 extends RoomWall(None, Seq.empty)
  object WallTwelve1 extends RoomWall(Some(DoorTwelveOne), Seq.empty)
  object WallTwelve2 extends RoomWall(None, Seq.empty)
  object WallTwelve3 extends RoomWall(Some(DoorElevenTwelve), Seq.empty)

  object WallOne0 extends RoomWall(None, Seq.empty)
  object WallOne1 extends RoomWall(Some(DoorwayOneTwo), Seq.empty)
  object WallOne2 extends RoomWall(None, Seq.empty)
  object WallOne3 extends RoomWall(Some(DoorTwelveOne), Seq.empty)

  object WallTwo0 extends RoomWall(None, Seq.empty)
  object WallTwo1 extends RoomWall(Some(DoorTwoThree), Seq.empty)
  object WallTwo2 extends RoomWall(None, Seq(Cabinet2))
  object WallTwo3 extends RoomWall(Some(DoorwayOneTwo), Seq.empty)

  object WallThree0 extends RoomWall(None, Seq.empty)
  object WallThree1 extends RoomWall(Some(DoorThreeFour), Seq.empty)
  object WallThree2 extends RoomWall(None, Seq.empty)
  object WallThree3 extends RoomWall(Some(DoorTwoThree), Seq.empty)

  object WallFour0 extends RoomWall(None, Seq.empty)
  object WallFour1 extends RoomWall(Some(DoorwayFourFive), Seq.empty)
  object WallFour2 extends RoomWall(None, Seq.empty)
  object WallFour3 extends RoomWall(Some(DoorThreeFour), Seq.empty)

  object WallFive0 extends RoomWall(None, Seq.empty)
  object WallFive1 extends RoomWall(Some(DoorFiveSix), Seq.empty)
  object WallFive2 extends RoomWall(None, Seq.empty)
  object WallFive3 extends RoomWall(Some(DoorwayFourFive), Seq.empty)

  object WallSix0 extends RoomWall(None, Seq.empty)
  object WallSix1 extends RoomWall(Some(DoorSixSeven), Seq.empty)
  object WallSix2 extends RoomWall(None, Seq.empty)
  object WallSix3 extends RoomWall(Some(DoorFiveSix), Seq.empty)

  object WallSeven0 extends RoomWall(None, Seq.empty)
  object WallSeven1 extends RoomWall(Some(DoorSevenEight), Seq.empty)
  object WallSeven2 extends RoomWall(None, Seq.empty)
  object WallSeven3 extends RoomWall(Some(DoorSixSeven), Seq.empty)

  object WallEight0 extends RoomWall(None, Seq.empty)
  object WallEight1 extends RoomWall(Some(DoorEightNine), Seq.empty)
  object WallEight2 extends RoomWall(None, Seq.empty)
  object WallEight3 extends RoomWall(Some(DoorSevenEight), Seq.empty)

  object WallNine0 extends RoomWall(None, Seq.empty)
  object WallNine1 extends RoomWall(Some(DoorNineTen), Seq.empty)
  object WallNine2 extends RoomWall(None, Seq.empty)
  object WallNine3 extends RoomWall(Some(DoorEightNine), Seq.empty)

  object WallTen0 extends RoomWall(None, Seq.empty)
  object WallTen1 extends RoomWall(Some(DoorTenEleven), Seq.empty)
  object WallTen2 extends RoomWall(None, Seq.empty)
  object WallTen3 extends RoomWall(Some(DoorNineTen), Seq.empty)

  object WallEleven0 extends RoomWall(None, Seq.empty)
  object WallEleven1 extends RoomWall(Some(DoorElevenTwelve), Seq.empty)
  object WallEleven2 extends RoomWall(None, Seq.empty)
  object WallEleven3 extends RoomWall(Some(DoorTenEleven), Seq(Lever11))
}
