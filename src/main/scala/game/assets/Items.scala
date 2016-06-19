package game.assets

import game.PlayerAction.{CheckMap, Rewind}
import game.assets.Pedestals.CenterPedestal
import game.assets.Scales.Scale3
import game.syntaxEn.SingularNoun
import game.{Inventory, Item, Weight}
import game.assets.RoomWalls._
import game.syntaxEn.Adjective.SilverAdj

object Items {
  object WeightThree0 extends Weight(Scale3.top, 5)
  object WeightThree1 extends Weight(WallThree2.floor, 10)
  object Compass extends Item(WallFour0.floor, Rewind, None, new SingularNoun("compass"), None)
  object GameMap extends Item(WallStorageFour2.floor, CheckMap, None, new SingularNoun("map"), None)
  object Locket extends Item(CenterPedestal.top, Rewind, Some(SilverAdj.toAp), new SingularNoun("locket"), None)

  val list = Seq(WeightThree0, WeightThree1, Compass, GameMap, Locket)
}
