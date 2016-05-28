package game.assets

import game.assets.Rooms._
import game.{AngledDoor, Door}
import game.assets.Keys._
import game.LockState._

object Doors {
  object ExitDoor extends AngledDoor(RoomTwelve, RoomOne, Unlocked, Some("iron"), None)

  object DoorTwelveOne extends AngledDoor(RoomTwelve, RoomOne, Unlocked, Some("iron"), None)

  object DoorwayOneTwo extends Door(RoomOne, RoomTwo, KeyLock(Room2Key), Some("iron"), None)

  object DoorTwoThree extends AngledDoor(RoomTwo, RoomThree, KeyLock(Room3Key), Some("iron"), None)

  object DoorThreeFour extends AngledDoor(RoomThree, RoomFour, Unlocked, Some("iron"), None)

  object DoorwayFourFive extends Door(RoomFour, RoomFive, Unlocked, Some("iron"), None)

  object DoorFiveSix extends AngledDoor(RoomFive, RoomSix, Unlocked, Some("iron"), None)

  object DoorSixSeven extends AngledDoor(RoomSix, RoomSeven, Unlocked, Some("iron"), None)

  object DoorSevenEight extends Door(RoomSeven, RoomEight, Unlocked, Some("iron"), None)

  object DoorEightNine extends AngledDoor(RoomEight, RoomNine, Unlocked, Some("iron"), None)

  object DoorNineTen extends AngledDoor(RoomNine, RoomTen, Unlocked, Some("iron"), None)

  object DoorTenEleven extends Door(RoomTen, RoomEleven, Unlocked, Some("iron"), None)

  object DoorElevenTwelve extends AngledDoor(RoomEleven, RoomTwelve, Unlocked, Some("iron"), None)
}
