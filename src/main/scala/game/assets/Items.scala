package game.assets

import game.PlayerAction.{CheckMap, Rewind, TakeItem}
import game.assets.Pedestals.CenterPedestal
import game.assets.Scales.Scale3
import game.syntaxEn.CountableNoun
import game._
import game.assets.RoomWalls._
import game.syntaxEn.Adjective.SilverAdj

object Items {
  object WeightThree0 extends Weight(Scale3.top, 5)
  object WeightThree1 extends Weight(WallThree2.floor, 10)
  object Compass extends Item(WallFour0.floor, Rewind, new CountableNoun("compass")) {
    val relSize = Some(Small)
    val material = Some(Metal)
    val image = None
    val text = None
  }
  object GameMap extends Item(WallStorageFour2.floor, CheckMap, new CountableNoun("map")) {
    val relSize = None
    val material = Some(Parchment)
    val image = None
    val text = None
  }
  object Locket extends Item(CenterPedestal.top, Rewind, new CountableNoun("locket")) {
    val relSize = Some(Small)
    val material = Some(Silver)
    val image = None
    val text = None
  }

  val list = Seq(WeightThree0, WeightThree1, Compass, GameMap, Locket)
}
