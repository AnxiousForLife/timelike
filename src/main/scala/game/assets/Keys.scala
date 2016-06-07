package game.assets

import game.assets.Cabinets._
import game.assets.RoomWalls._
import game.Key
import game.Undefined

object Keys {
  object ExitKey extends Key(Undefined, None, None)
  object Room2Key extends Key(WallOne0.floor, None, Some(Key.numeral(2)))
  object Room3Key extends Key(Cabinet2.interior, None, Some(Key.numeral(3)))
  object Room5Key extends Key(WallNine2.floor, None, Some(Key.numeral(5)))
  object Room6Key extends Key(WallSeven0.floor, None, Some(Key.numeral(6)))
  object Room11Key extends Key(WallCloset0.floor, None, Some(Key.numeral(11)))
}