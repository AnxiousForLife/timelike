package game.assets

import game.Direction._
import game.{Balcony, Room}
import game.assets.Objectives._
import game.assets.RoomWalls._

object Rooms{
  object RoomFirst extends Room(North) {
    override val description = "small stone room"

    override lazy val wall0 = WallFirst0
    override lazy val wall1 = WallFirst1
    override lazy val wall2 = WallFirst2
    override lazy val wall3 = WallFirst3

    override val objective = Some(ExitFirstRoom)
  }

  object RoomSecond extends Room(North) {
    override val description = "small stone room"

    override lazy val wall0 = WallSecond0
    override lazy val wall1 = WallSecond1
    override lazy val wall2 = WallSecond2
    override lazy val wall3 = WallSecond3
  }

  object RoomTwelve extends Room(North) {
    override val description = "stone room. Tall tree trunks reach like slender fingers from the dirt floor to the ceiling"

    override lazy val wall0 = WallTwelve0
    override lazy val wall1 = WallTwelve1
    override lazy val wall2 = WallTwelve2
    override lazy val wall3 = WallTwelve3
  }

  object RoomEnd extends Room(North) {
    override val description = ""

    override lazy val wall0 = WallEnd0
    override lazy val wall1 = WallEnd1
    override lazy val wall2 = WallEnd2
    override lazy val wall3 = WallEnd3
  }

  object RoomOne extends Room(NorthEast) {
    override val description = "stone room. The dirt on the floor is brushed away to reveal a stone path leading out from the trees."

    override lazy val wall0 = WallOne0
    override lazy val wall1 = WallOne1
    override lazy val wall2 = WallOne2
    override lazy val wall3 = WallOne3
  }

  object RoomTwo extends Room(NorthEast) {
    override val description = "room lol"

    override lazy val wall0 = WallTwo0
    override lazy val wall1 = WallTwo1
    override lazy val wall2 = WallTwo2
    override lazy val wall3 = WallTwo3
  }

  object RoomThree extends Room(East) {
    override val description = "room lol"

    override lazy val wall0 = WallThree0
    override lazy val wall1 = WallThree1
    override lazy val wall2 = WallThree2
    override lazy val wall3 = WallThree3
  }

  object SecretRoomThree extends Room(East) {
    override val description = "room lol"

    override lazy val wall0 = WallSecret0
    override lazy val wall1 = WallSecret1
    override lazy val wall2 = WallSecret2
    override lazy val wall3 = WallSecret3
  }

  object RoomFour extends Room(SouthEast) {
    override val description = "room lol"

    override lazy val wall0 = WallFour0
    override lazy val wall1 = WallFour1
    override lazy val wall2 = WallFour2
    override lazy val wall3 = WallFour3
  }

  object ClosetAccess extends Room(SouthEast) {
    override val description = "room lol"

    override lazy val wall0 = WallClosetAccess0
    override lazy val wall1 = WallClosetAccess1
    override lazy val wall2 = WallClosetAccess2
    override lazy val wall3 = WallClosetAccess3
  }

  object Closet extends Room(SouthEast) {
    override val description = "room lol"

    override lazy val wall0 = WallCloset0
    override lazy val wall1 = WallCloset1
    override lazy val wall2 = WallCloset2
    override lazy val wall3 = WallCloset3
  }

  object RoomFive extends Room(SouthEast) {
    override val description = "room lol"

    override lazy val wall0 = WallFive0
    override lazy val wall1 = WallFive1
    override lazy val wall2 = WallFive2
    override lazy val wall3 = WallFive3
  }

  object RoomSix extends Room(South) {
    override val description = "room six"

    override lazy val wall0 = WallSix0
    override lazy val wall1 = WallSix1
    override lazy val wall2 = WallSix2
    override lazy val wall3 = WallSix3
  }

  object RoomSixAccess extends Room(South) {
    override val description = "room six access"

    override lazy val wall0 = WallSixAccess0
    override lazy val wall1 = WallSixAccess1
    override lazy val wall2 = WallSixAccess2
    override lazy val wall3 = WallSixAccess3
  }

  object RoomCenterAccess extends Room(South) {
    override val description = "room center access"

    override lazy val wall0 = WallCenterAccess0
    override lazy val wall1 = WallCenterAccess1
    override lazy val wall2 = WallCenterAccess2
    override lazy val wall3 = WallCenterAccess3
  }

  object RoomCenter extends Room(South) {
    override val description = "room center"

    override lazy val wall0 = WallCenterRoom0
    override lazy val wall1 = WallCenterRoom1
    override lazy val wall2 = WallCenterRoom2
    override lazy val wall3 = WallCenterRoom3
  }


  object RoomSeven extends Room(SouthWest) {
    override val description = "room lol"

    override lazy val wall0 = WallSeven0
    override lazy val wall1 = WallSeven1
    override lazy val wall2 = WallSeven2
    override lazy val wall3 = WallSeven3
  }

  object RoomEight extends Room(SouthWest) {
    override val description = "room lol"

    override lazy val wall0 = WallEight0
    override lazy val wall1 = WallEight1
    override lazy val wall2 = WallEight2
    override lazy val wall3 = WallEight3
  }

  object SouthBalcony extends Room(SouthWest) with Balcony {
    override val description = "balcony"

    override lazy val wall0 = WallSouthBalcony0
    override lazy val wall1 = WallSouthBalcony1
    override lazy val wall2 = WallSouthBalcony2
    override lazy val wall3 = WallSouthBalcony3
  }

  object RoomNine extends Room(West) {
    override val description = "room lol"

    override lazy val wall0 = WallNine0
    override lazy val wall1 = WallNine1
    override lazy val wall2 = WallNine2
    override lazy val wall3 = WallNine3
  }

  object MidBalcony extends Room(West) with Balcony {
    override val description = "balcony"

    override lazy val wall0 = WallMidBalcony0
    override lazy val wall1 = WallMidBalcony1
    override lazy val wall2 = WallMidBalcony2
    override lazy val wall3 = WallMidBalcony3
  }

  object RoomTen extends Room(NorthWest) {
    override val description = "room lol"

    override lazy val wall0 = WallTen0
    override lazy val wall1 = WallTen1
    override lazy val wall2 = WallTen2
    override lazy val wall3 = WallTen3
  }

  object NorthBalcony extends Room(NorthWest) with Balcony {
    override val description = "balcony"

    override lazy val wall0 = WallNorthBalcony0
    override lazy val wall1 = WallNorthBalcony1
    override lazy val wall2 = WallNorthBalcony2
    override lazy val wall3 = WallNorthBalcony3
  }

  object RoomEleven extends Room(NorthWest) {
    override val description = "room lol"

    override lazy val wall0 = WallEleven0
    override lazy val wall1 = WallEleven1
    override lazy val wall2 = WallEleven2
    override lazy val wall3 = WallEleven3
  }
}