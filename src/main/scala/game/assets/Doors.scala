package game.assets

import game.assets.Rooms.{RoomEight, RoomTen, SouthBalcony, _}
import game._
import game.assets.Keys._
import game.LockState._
import game.syntaxEn.Adjective._
import game.syntaxEn.Noun._

object Doors {
  object DoorFirstSecond extends Doorway(RoomFirst, RoomSecond, None, DoorwayNoun, None)

  object DoorSecondTwelve extends SingleDoor(RoomTwelve, RoomSecond, Some(WoodenAdj.toAp), None)

  object ExitDoor extends DoorPair(RoomTwelve, RoomEnd) {
    lock = KeyLock(ExitKey)
  }

  object DoorTwelveOne extends SingleDoor(RoomTwelve, RoomOne, Some(IronAdj.toAp), None)

  object DoorOneTwo extends SingleDoor(RoomOne, RoomTwo, Some(IronAdj.toAp), None) {
    lock = KeyLock(Room2Key)
  }

  object DoorTwoThree extends SingleDoor(RoomTwo, RoomThree, Some(IronAdj.toAp), None) {
    lock = KeyLock(Room3Key)
  }

  object SecretDoorThree extends ConcealedDoor(RoomThree, SecretRoomThree, None, None)

  object DoorThreeFour extends SingleDoor(RoomThree, RoomFour, Some(IronAdj.toAp), None)

  object ClosetAccessDoor extends SingleDoor(RoomFour, ClosetAccess, Some(WoodenAdj.toAp), None)

  object ClosetDoor extends SingleDoor(ClosetAccess, Closet, Some(WoodenAdj.toAp), None)

  object DoorFourFive extends SingleDoor(RoomFour, RoomFive, Some(IronAdj.toAp), None)

  object DoorFiveSix extends SingleDoor(RoomFive, RoomSix, Some(IronAdj.toAp), None)

  object DoorSixAccess extends SingleDoor(RoomSixAccess, RoomSix, Some(IronAdj.toAp), None)

  object DoorMidAccess extends SingleDoor(RoomCenterAccess, RoomSixAccess, Some(IronAdj.toAp), None)

  object DoorCenterAccess extends SingleDoor(RoomCenter, RoomCenterAccess, Some(IronAdj.toAp), None)

  object DoorSixSeven extends SingleDoor(RoomSix, RoomSeven, Some(IronAdj.toAp), None)

  object DoorSevenEight extends SingleDoor(RoomSeven, RoomEight, Some(IronAdj.toAp), None)

  object DoorEightNine extends SingleDoor(RoomEight, RoomNine, Some(IronAdj.toAp), None)

  object DoorSouthBalcony extends SingleDoor(RoomEight, SouthBalcony, Some(IronAdj.toAp), None)

  object SouthWalkway extends BalconyWalkway(SouthBalcony, MidBalcony)

  object DoorNineTen extends SingleDoor(RoomNine, RoomTen, Some(IronAdj.toAp), None)

  object DoorNorthBalcony extends SingleDoor(NorthBalcony, RoomTen, Some(IronAdj.toAp), None)

  object NorthWalkway extends BalconyWalkway(MidBalcony, NorthBalcony)

  object DoorTenEleven extends SingleDoor(RoomTen, RoomEleven, Some(IronAdj.toAp), None)

  object DoorElevenTwelve extends SingleDoor(RoomEleven, RoomTwelve, Some(IronAdj.toAp), None)
}
