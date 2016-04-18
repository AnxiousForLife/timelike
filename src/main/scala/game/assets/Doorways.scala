package game.assets

object Doorways {

  import game.{AngledDoorway, Doorway}
  import game.assets.Keys._
  import game.LockState._

  object DoorwayTwelveOne extends AngledDoorway(RoomTwelve, RoomOne, Unlocked)

  object DoorwayOneTwo extends Doorway(RoomOne, RoomTwo, KeyLock(Room2Key))

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

}
