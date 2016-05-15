package game.assets

object Doors {
  import game.{AngledDoor, Door}
  import game.assets.Keys._
  import game.LockState._

  object DoorTwelveOne$ extends AngledDoor(RoomTwelve, RoomOne, Unlocked)

  object DoorwayOneTwo extends Door(RoomOne, RoomTwo, KeyLock(Room2Key))

  object DoorTwoThree$ extends AngledDoor(RoomTwo, RoomThree, Unlocked)

  object DoorThreeFour$ extends AngledDoor(RoomThree, RoomFour, Unlocked)

  object DoorwayFourFive extends Door(RoomFour, RoomFive, Unlocked)

  object DoorFiveSix$ extends AngledDoor(RoomFive, RoomSix, Unlocked)

  object DoorSixSeven$ extends AngledDoor(RoomSix, RoomSeven, Unlocked)

  object DoorwaySevenEight extends Door(RoomSeven, RoomEight, Unlocked)

  object DoorEightNine$ extends AngledDoor(RoomEight, RoomNine, Unlocked)

  object DoorNineTen$ extends AngledDoor(RoomNine, RoomTen, Unlocked)

  object DoorwayTenEleven extends Door(RoomTen, RoomEleven, Unlocked)

  object DoorElevenTwelve$ extends AngledDoor(RoomEleven, RoomTwelve, Unlocked)

}
