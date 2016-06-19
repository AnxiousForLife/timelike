package game.assets

import game.Direction._
import game.{Balcony, Room}
import game.assets.RoomWalls._

object Rooms{
  object DungeonCell extends Room(North, "dungeon cell") {
    override val properName = "the " ++ name
    override val description = "you're in a small stone room. The floor is wet. Two rusty chains with shackles hang from the ceiling."

    override lazy val wall0 = WallFirst0
    override lazy val wall1 = WallFirst1
    override lazy val wall2 = WallFirst2
    override lazy val wall3 = WallFirst3
  }

  object DungeonAccess extends Room(North, "dungeon access") {
    override val properName = "the " ++ name
    override val description = "you're in a small stone room. The floor is wet. A small, broken chair sits against the wall."

    override lazy val wall0 = WallSecond0
    override lazy val wall1 = WallSecond1
    override lazy val wall2 = WallSecond2
    override lazy val wall3 = WallSecond3
  }

  object RoomTwelve extends Room(North, "room twelve") {
    override val description = "you're in a stone room. Tall tree trunks reach like slender fingers from the dirt floor to the ceiling."

    override lazy val wall0 = WallTwelve0
    override lazy val wall1 = WallTwelve1
    override lazy val wall2 = WallTwelve2
    override lazy val wall3 = WallTwelve3
  }

  object RoomEnd extends Room(North, "") {
    override val description = ""

    override lazy val wall0 = WallEnd0
    override lazy val wall1 = WallEnd1
    override lazy val wall2 = WallEnd2
    override lazy val wall3 = WallEnd3
  }

  object RoomOne extends Room(NorthEast, "room one") {
    override val description = "you're in a stone room. The dirt on the floor is brushed away to reveal a stone path leading out from the trees."

    override lazy val wall0 = WallOne0
    override lazy val wall1 = WallOne1
    override lazy val wall2 = WallOne2
    override lazy val wall3 = WallOne3
  }

  object RoomTwo extends Room(NorthEast, "room two") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallTwo0
    override lazy val wall1 = WallTwo1
    override lazy val wall2 = WallTwo2
    override lazy val wall3 = WallTwo3
  }

  object RoomThree extends Room(East, "room three") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallThree0
    override lazy val wall1 = WallThree1
    override lazy val wall2 = WallThree2
    override lazy val wall3 = WallThree3
  }

  object SecretRoomThree extends Room(East, "storage room three") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallStorageThree0
    override lazy val wall1 = WallStorageThree1
    override lazy val wall2 = WallStorageThree2
    override lazy val wall3 = WallStorageThree3
  }

  object RoomFour extends Room(SouthEast, "room four") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallFour0
    override lazy val wall1 = WallFour1
    override lazy val wall2 = WallFour2
    override lazy val wall3 = WallFour3
  }

  object StorageAccess extends Room(SouthEast, "storage access") {
    override val properName = "the " ++ name
    override val description = "you're in a room lol."

    override lazy val wall0 = WallStorageAccess0
    override lazy val wall1 = WallStorageAccess1
    override lazy val wall2 = WallStorageAccess2
    override lazy val wall3 = WallStorageAccess3
  }

  object StorageRoomFour extends Room(SouthEast, "storage room four") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallStorageFour0
    override lazy val wall1 = WallStorageFour1
    override lazy val wall2 = WallStorageFour2
    override lazy val wall3 = WallStorageFour3
  }

  object RoomFive extends Room(SouthEast, "room five") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallFive0
    override lazy val wall1 = WallFive1
    override lazy val wall2 = WallFive2
    override lazy val wall3 = WallFive3
  }

  object RoomSix extends Room(South, "room six") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallSix0
    override lazy val wall1 = WallSix1
    override lazy val wall2 = WallSix2
    override lazy val wall3 = WallSix3
  }

  object AtriumHallA extends Room(South, "atrium hall A") {
    override val description = "you're in a room with walls of bronze."

    override lazy val wall0 = WallSixAccess0
    override lazy val wall1 = WallSixAccess1
    override lazy val wall2 = WallSixAccess2
    override lazy val wall3 = WallSixAccess3
  }

  object AtriumHallB extends Room(South, "atrium hall B") {
    override val description = "you're in a room with walls of bronze."

    override lazy val wall0 = WallCenterAccess0
    override lazy val wall1 = WallCenterAccess1
    override lazy val wall2 = WallCenterAccess2
    override lazy val wall3 = WallCenterAccess3
  }

  object RoomCenter extends Room(South, "atrium") {
    override val properName = "the " ++ name
    override val description = "you walk into a great, brightly lit room, walled off by a cylinder of glass, which" +
      " extends endlessly up and down. You stand upon a firm floor of glowing sand, and you look to see a great" +
      " ceiling of sand impossibly suspended above you. In fact, the whole of the glass room is suspended in a sea of" +
      " glowing sand, which envelopes you in a soft white-golden light. Slender, white-barked trees reach up from the" +
      " sand below you and down from the ceiling above you, like bony hands too far apart to reach one another. Rays" +
      " of light pierce through their fingers and illuminate glittering grains of sand drifting down from the ceiling" +
      " like dust."

    override lazy val wall0 = WallCenterRoom0
    override lazy val wall1 = WallCenterRoom1
    override lazy val wall2 = WallCenterRoom2
    override lazy val wall3 = WallCenterRoom3
  }


  object RoomSeven extends Room(SouthWest, "room seven") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallSeven0
    override lazy val wall1 = WallSeven1
    override lazy val wall2 = WallSeven2
    override lazy val wall3 = WallSeven3
  }

  object RoomEight extends Room(SouthWest, "room eight") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallEight0
    override lazy val wall1 = WallEight1
    override lazy val wall2 = WallEight2
    override lazy val wall3 = WallEight3
  }

  object SouthBalcony extends Room(SouthWest, "south balcony") with Balcony {
    override val properName = "the " ++ name
    override val description = "you stand outside on a balcony. It's night. The air is hot and still. Beyond the metal" +
      " railing stretches a vast sea, a black sea, blanketed with a still fog. Across the sea stand slender tree trunks," +
      " bare, perfectly straight, all sprouting endlessly upward. Just over the horizon, a grey, dead moon hangs in the" +
      " sky, shrouded in a dim halo of foggy light. But above the moon, where the night sky should continue, shines the" +
      " dim glow of rippling water in the fog, as if the whole of the world were submerged just below another body of" +
      " water."

    override lazy val wall0 = WallSouthBalcony0
    override lazy val wall1 = WallSouthBalcony1
    override lazy val wall2 = WallSouthBalcony2
    override lazy val wall3 = WallSouthBalcony3
  }

  object RoomNine extends Room(West, "room nine") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallNine0
    override lazy val wall1 = WallNine1
    override lazy val wall2 = WallNine2
    override lazy val wall3 = WallNine3
  }

  object RoomTen extends Room(NorthWest, "room ten") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallTen0
    override lazy val wall1 = WallTen1
    override lazy val wall2 = WallTen2
    override lazy val wall3 = WallTen3
  }

  object NorthBalcony extends Room(NorthWest, "north balcony") with Balcony {
    override val properName = "the " ++ name
    override val description = "you stand outside on a balcony. It's night. The air is hot and still. An outgrowth of" +
      "gnarly brush blocks your view of the horizon past the metal railing."

    override lazy val wall0 = WallNorthBalcony0
    override lazy val wall1 = WallNorthBalcony1
    override lazy val wall2 = WallNorthBalcony2
    override lazy val wall3 = WallNorthBalcony3
  }

  object RoomEleven extends Room(NorthWest, "room eleven") {
    override val description = "you're in a room lol."

    override lazy val wall0 = WallEleven0
    override lazy val wall1 = WallEleven1
    override lazy val wall2 = WallEleven2
    override lazy val wall3 = WallEleven3
  }
}