package game.assets

//Walls are listed starting with the outer wall, then going clockwise
object RoomWalls {
  import game.assets.Doors._
  import game.assets.Cabinets._
  import game.assets.Levers._
  import game.RoomWall

  object WallFirst0 extends RoomWall(None, Seq.empty)
  object WallFirst1 extends RoomWall(None, Seq.empty)
  object WallFirst2 extends RoomWall(None, Seq.empty)
  object WallFirst3 extends RoomWall(Some(DoorFirstSecond), Seq.empty)

  object WallSecond0 extends RoomWall(Some(DoorSecondTwelve), Seq.empty)
  object WallSecond1 extends RoomWall(None, Seq.empty)
  object WallSecond2 extends RoomWall(None, Seq.empty)
  object WallSecond3 extends RoomWall(None, Seq.empty)

  object WallTwelve0 extends RoomWall(Some(ExitDoor), Seq.empty)
  object WallTwelve1 extends RoomWall(Some(DoorTwelveOne), Seq.empty)
  object WallTwelve2 extends RoomWall(None, Seq.empty)
  object WallTwelve3 extends RoomWall(Some(DoorElevenTwelve), Seq.empty)

  object WallEnd0 extends RoomWall(None, Seq.empty)
  object WallEnd1 extends RoomWall(None, Seq.empty)
  object WallEnd2 extends RoomWall(None, Seq.empty)
  object WallEnd3 extends RoomWall(None, Seq.empty)

  object WallOne0 extends RoomWall(None, Seq.empty)
  object WallOne1 extends RoomWall(Some(DoorOneTwo), Seq.empty)
  object WallOne2 extends RoomWall(None, Seq.empty)
  object WallOne3 extends RoomWall(Some(DoorTwelveOne), Seq.empty)

  object WallTwo0 extends RoomWall(None, Seq.empty)
  object WallTwo1 extends RoomWall(Some(DoorTwoThree), Seq.empty)
  object WallTwo2 extends RoomWall(None, Seq(Cabinet2))
  object WallTwo3 extends RoomWall(Some(DoorOneTwo), Seq.empty)

  object WallThree0 extends RoomWall(Some(SecretDoorThree), Seq.empty)
  object WallThree1 extends RoomWall(Some(DoorThreeFour), Seq.empty)
  object WallThree2 extends RoomWall(None, Seq.empty)
  object WallThree3 extends RoomWall(Some(DoorTwoThree), Seq.empty)

  object WallSecret0 extends RoomWall(None, Seq.empty)
  object WallSecret1 extends RoomWall(None, Seq.empty)
  object WallSecret2 extends RoomWall(Some(DoorTwoThree), Seq.empty)
  object WallSecret3 extends RoomWall(None, Seq.empty)

  object WallFour0 extends RoomWall(None, Seq.empty)
  object WallFour1 extends RoomWall(Some(DoorFourFive), Seq.empty)
  object WallFour2 extends RoomWall(Some(ClosetAccessDoor), Seq.empty)
  object WallFour3 extends RoomWall(Some(DoorThreeFour), Seq.empty)

  object WallClosetAccess0 extends RoomWall(None, Seq.empty)
  object WallClosetAccess1 extends RoomWall(None, Seq.empty)
  object WallClosetAccess2 extends RoomWall(Some(ClosetDoor), Seq.empty)
  object WallClosetAccess3 extends RoomWall(None, Seq(ClosetLever))

  object WallCloset0 extends RoomWall(None, Seq.empty)
  object WallCloset1 extends RoomWall(None, Seq.empty)
  object WallCloset2 extends RoomWall(None, Seq.empty)
  object WallCloset3 extends RoomWall(None, Seq.empty)

  object WallFive0 extends RoomWall(None, Seq.empty)
  object WallFive1 extends RoomWall(Some(DoorFiveSix), Seq.empty)
  object WallFive2 extends RoomWall(None, Seq.empty)
  object WallFive3 extends RoomWall(Some(DoorFourFive), Seq.empty)

  object WallSix0 extends RoomWall(None, Seq.empty)
  object WallSix1 extends RoomWall(Some(DoorSixSeven), Seq.empty)
  object WallSix2 extends RoomWall(Some(DoorSixAccess), Seq.empty)
  object WallSix3 extends RoomWall(Some(DoorFiveSix), Seq.empty)

  object WallSixAccess0 extends RoomWall(Some(DoorSixAccess), Seq.empty)
  object WallSixAccess1 extends RoomWall(None, Seq.empty)
  object WallSixAccess2 extends RoomWall(Some(DoorMidAccess), Seq.empty)
  object WallSixAccess3 extends RoomWall(None, Seq.empty)

  object WallCenterAccess0 extends RoomWall(Some(DoorMidAccess), Seq.empty)
  object WallCenterAccess1 extends RoomWall(None, Seq.empty)
  object WallCenterAccess2 extends RoomWall(Some(DoorCenterAccess), Seq.empty)
  object WallCenterAccess3 extends RoomWall(None, Seq(CenterAccessLever))

  object WallCenterRoom0 extends RoomWall(Some(DoorCenterAccess), Seq.empty)
  object WallCenterRoom1 extends RoomWall(None, Seq.empty)
  object WallCenterRoom2 extends RoomWall(None, Seq.empty)
  object WallCenterRoom3 extends RoomWall(None, Seq.empty)

  object WallSeven0 extends RoomWall(None, Seq.empty)
  object WallSeven1 extends RoomWall(Some(DoorSevenEight), Seq.empty)
  object WallSeven2 extends RoomWall(None, Seq.empty)
  object WallSeven3 extends RoomWall(Some(DoorSixSeven), Seq(Lever6))

  object WallEight0 extends RoomWall(Some(DoorSouthBalcony), Seq.empty)
  object WallEight1 extends RoomWall(Some(DoorEightNine), Seq.empty)
  object WallEight2 extends RoomWall(None, Seq.empty)
  object WallEight3 extends RoomWall(Some(DoorSevenEight), Seq.empty)

  object WallSouthBalcony0 extends RoomWall(None, Seq.empty)
  object WallSouthBalcony1 extends RoomWall(Some(SouthWalkway), Seq.empty)
  object WallSouthBalcony2 extends RoomWall(Some(DoorSouthBalcony), Seq.empty)
  object WallSouthBalcony3 extends RoomWall(None, Seq.empty)

  object WallNine0 extends RoomWall(None, Seq.empty)
  object WallNine1 extends RoomWall(Some(DoorNineTen), Seq.empty)
  object WallNine2 extends RoomWall(None, Seq.empty)
  object WallNine3 extends RoomWall(Some(DoorEightNine), Seq(Lever9))

  object WallMidBalcony0 extends RoomWall(None, Seq.empty)
  object WallMidBalcony1 extends RoomWall(Some(NorthWalkway), Seq.empty)
  object WallMidBalcony2 extends RoomWall(None, Seq.empty)
  object WallMidBalcony3 extends RoomWall(Some(SouthWalkway), Seq.empty)

  object WallTen0 extends RoomWall(Some(DoorNorthBalcony), Seq.empty)
  object WallTen1 extends RoomWall(Some(DoorTenEleven), Seq.empty)
  object WallTen2 extends RoomWall(None, Seq.empty)
  object WallTen3 extends RoomWall(Some(DoorNineTen), Seq.empty)

  object WallNorthBalcony0 extends RoomWall(None, Seq.empty)
  object WallNorthBalcony1 extends RoomWall(None, Seq.empty)
  object WallNorthBalcony2 extends RoomWall(Some(DoorNorthBalcony), Seq.empty)
  object WallNorthBalcony3 extends RoomWall(Some(NorthWalkway), Seq.empty)

  object WallEleven0 extends RoomWall(None, Seq.empty)
  object WallEleven1 extends RoomWall(Some(DoorElevenTwelve), Seq.empty)
  object WallEleven2 extends RoomWall(None, Seq.empty)
  object WallEleven3 extends RoomWall(Some(DoorTenEleven), Seq(Lever11))
}
