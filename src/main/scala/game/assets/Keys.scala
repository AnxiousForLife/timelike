package game.assets

import game.assets.Cabinets._
import game.assets.RoomWalls._
import game.assets.Doors._
import game._
import game.assets.Rooms.DungeonCell
import game.syntaxEn.Verb.Engrave

object Keys {
  object ExitKey extends Key(Undefined) {
    val relSize = None
    val material = None
    val image = None
    val text = None
  }
  object Room2Key extends Key(WallOne0.floor) {
    val relSize = Some(Small)
    val material = None
    val image = None
    val text = Some(new Engraving("2"))
  }
  object Room3Key extends Key(Cabinet2.interior) {
    val relSize = Some(Small)
    val material = None
    val image = None
    val text = Some(new Engraving("3"))
  }
  object Room5Key extends Key(WallNine2.floor) {
    val relSize = Some(Small)
    val material = None
    val image = None
    val text = Some(new Engraving("5"))
  }
  object Room6Key extends Key(WallSeven0.floor) {
    val relSize = Some(Small)
    val material = None
    val image = None
    val text = Some(new Engraving("6"))
  }
  object BalconyKey extends Key(WallFive0.floor) {
    val relSize = None
    val material = None
    val image = None
    val text = None
  }
  object Room11Key extends Key(WallStorageFour0.floor) {
    val relSize = Some(Small)
    val material = None
    val image = None
    val text = Some(new Engraving("11"))
  }

  val list = Seq(ExitKey, Room2Key, Room3Key, Room5Key, Room6Key, BalconyKey, Room11Key)
}