package game.assets

import game.assets.Rooms.{RoomEight, RoomTen, SouthBalcony, _}
import game._
import game.assets.Keys._
import game.LockState._
import game.syntaxEn.Noun._

object Doors {
  object DoorFirstSecond extends Doorway(DungeonCell, DungeonAccess, DoorwayNoun) {
    val relSize = Some(Small)
    val material = Some(Stone)
  }

  object DoorSecondTwelve extends SingleDoor(RoomTwelve, DungeonAccess) {
    val relSize = Some(Small)
    val material = Some(Wooden)
  }

  object ExitDoor extends DoorPair(RoomTwelve, RoomEnd) {
    val relSize = Some(Large)
    val material = Some(Wooden)

    lock = KeyLock(ExitKey)
  }

  object DoorTwelveOne extends SingleDoor(RoomTwelve, RoomOne) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorOneTwo extends SingleDoor(RoomOne, RoomTwo) {
    val relSize = None
    val material = Some(Iron)

    lock = KeyLock(Room2Key)
  }

  object DoorTwoThree extends SingleDoor(RoomTwo, RoomThree) {
    val relSize = None
    val material = Some(Iron)

    lock = KeyLock(Room3Key)
  }

  object SecretDoorThree extends ConcealedDoor(RoomThree, SecretRoomThree)

  object DoorThreeFour extends SingleDoor(RoomThree, RoomFour) {
    val relSize = None
    val material = Some(Iron)
  }

  object ClosetAccessDoor extends SingleDoor(RoomFour, StorageAccess) {
    val relSize = Some(Small)
    val material = Some(Wooden)
  }

  object ClosetDoor extends SingleDoor(StorageAccess, StorageRoomFour){
    val relSize = Some(Small)
    val material = Some(Wooden)
  }

  object DoorFourFive extends SingleDoor(RoomFour, RoomFive) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorFiveSix extends SingleDoor(RoomFive, RoomSix) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorSixAccess extends SingleDoor(AtriumHallA, RoomSix) {
    val relSize = Some(Large)
    val material = Some(Brass)
  }

  object DoorMidAccess extends SingleDoor(AtriumHallB, AtriumHallA) {
    val relSize = Some(Large)
    val material = Some(Brass)
  }

  object DoorCenterAccess extends SingleDoor(RoomCenter, AtriumHallB) {
    val relSize = Some(Large)
    val material = Some(Brass)
  }

  object DoorSixSeven extends SingleDoor(RoomSix, RoomSeven) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorSevenEight extends SingleDoor(RoomSeven, RoomEight) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorEightNine extends SingleDoor(RoomEight, RoomNine) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorSouthBalcony extends SingleDoor(RoomEight, SouthBalcony) {
    val relSize = None
    val material = Some(Metal)
  }

  object DoorNineTen extends SingleDoor(RoomNine, RoomTen) {
    val relSize = None
    val material = Some(Iron)
  }

  object BalconyWalkway extends BalconyWalkway(SouthBalcony, NorthBalcony) {
    val relSize = None
    val material = Some(Metal)
  }

  object DoorNorthBalcony extends SingleDoor(NorthBalcony, RoomTen) {
    val relSize = None
    val material = Some(Metal)

    lock = KeyLock(BalconyKey)
  }

  object DoorTenEleven extends SingleDoor(RoomTen, RoomEleven) {
    val relSize = None
    val material = Some(Iron)
  }

  object DoorElevenTwelve extends SingleDoor(RoomEleven, RoomTwelve) {
    val relSize = None
    val material = Some(Iron)
  }
}
