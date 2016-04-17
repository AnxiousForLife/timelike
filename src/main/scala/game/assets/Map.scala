package game.assets

import game.Direction._
import game.Room
import game.assets.RoomWalls._

object RoomTwelve extends Room("Room 12", North) {
  override lazy val wall0 = WallTwelve0
  override lazy val wall1 = WallTwelve1
  override lazy val wall2 = WallTwelve2
  override lazy val wall3 = WallTwelve3
}

object RoomOne extends Room("Room 1", NorthEast) {
  override lazy val wall0 = WallOne0
  override lazy val wall1 = WallOne1
  override lazy val wall2 = WallOne2
  override lazy val wall3 = WallOne3
}

object RoomTwo extends Room("Room 2", NorthEast) {
  override lazy val wall0 = WallTwo0
  override lazy val wall1 = WallTwo1
  override lazy val wall2 = WallTwo2
  override lazy val wall3 = WallTwo3
}

object RoomThree extends Room("Room 3", East) {
  override lazy val wall0 = WallThree0
  override lazy val wall1 = WallThree1
  override lazy val wall2 = WallThree2
  override lazy val wall3 = WallThree3
}

object RoomFour extends Room("Room 4", SouthEast) {
  override lazy val wall0 = WallFour0
  override lazy val wall1 = WallFour1
  override lazy val wall2 = WallFour2
  override lazy val wall3 = WallFour3
}

object RoomFive extends Room("Room 5", SouthEast) {
  override lazy val wall0 = WallFive0
  override lazy val wall1 = WallFive1
  override lazy val wall2 = WallFive2
  override lazy val wall3 = WallFive3
}

object RoomSix extends Room("Room 6", South) {
  override lazy val wall0 = WallSix0
  override lazy val wall1 = WallSix1
  override lazy val wall2 = WallSix2
  override lazy val wall3 = WallSix3
}

object RoomSeven extends Room("Room 7", SouthWest) {
  override lazy val wall0 = WallSeven0
  override lazy val wall1 = WallSeven1
  override lazy val wall2 = WallSeven2
  override lazy val wall3 = WallSeven3
}

object RoomEight extends Room("Room 8", SouthWest) {
  override lazy val wall0 = WallEight0
  override lazy val wall1 = WallEight1
  override lazy val wall2 = WallEight2
  override lazy val wall3 = WallEight3
}

object RoomNine extends Room("Room 9", West) {
  override lazy val wall0 = WallNine0
  override lazy val wall1 = WallNine1
  override lazy val wall2 = WallNine2
  override lazy val wall3 = WallNine3
}

object RoomTen extends Room("Room 10", NorthWest) {
  override lazy val wall0 = WallTen0
  override lazy val wall1 = WallTen1
  override lazy val wall2 = WallTen2
  override lazy val wall3 = WallTen3
}

object RoomEleven extends Room("Room 11", NorthWest) {
  override lazy val wall0 = WallEleven0
  override lazy val wall1 = WallEleven1
  override lazy val wall2 = WallEleven2
  override lazy val wall3 = WallEleven3
}