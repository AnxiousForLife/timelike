package game

//Connector for two Rooms, listed clockwise
class Doorway(val room1: Room, val room2: Room)
class AngledDoorway(override val room1: Room, override val room2: Room) extends Doorway(room1, room2)

object DoorwayTwelveOne extends AngledDoorway(RoomTwelve, RoomOne)
object DoorwayOneTwo extends Doorway(RoomOne, RoomTwo)
object DoorwayTwoThree extends AngledDoorway(RoomTwo, RoomThree)
object DoorwayThreeFour extends AngledDoorway(RoomThree, RoomFour)
object DoorwayFourFive extends Doorway(RoomFour, RoomFive)
object DoorwayFiveSix extends AngledDoorway(RoomFive, RoomSix)
object DoorwaySixSeven extends AngledDoorway(RoomSix, RoomSeven)
object DoorwaySevenEight extends Doorway(RoomSeven, RoomEight)
object DoorwayEightNine extends AngledDoorway(RoomEight, RoomNine)
object DoorwayNineTen extends AngledDoorway(RoomNine, RoomTen)
object DoorwayTenEleven extends Doorway(RoomTen, RoomEleven)
object DoorwayElevenTwelve extends AngledDoorway(RoomEleven, RoomTwelve)