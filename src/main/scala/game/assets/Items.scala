package game.assets

import game.assets.Pedestals.CenterPedestal
import game.syntaxEn.SingularNoun
import game.{Inventory, Item}
import game.assets.RoomWalls._

object Items {
  object Compass extends Item(WallFour0.floor, None, new SingularNoun("compass"), None)
  object Map extends Item(/*WallStorageFour2.floor*/ Inventory, None, new SingularNoun("map"), None)
  object Locket extends Item(CenterPedestal.top, None, new SingularNoun("locket"), None)

  val list = Set(Compass, Locket)
}
