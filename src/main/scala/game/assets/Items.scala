package game.assets

import game.assets.Pedestals.CenterPedestal
import game.syntaxEn.SingularNoun
import game.{Inventory, Item}
import game.assets.RoomWalls._

object Items {
  object Compass extends Item(WallFour0.floor, ap = None, noun = new SingularNoun("compass"), pp = None)
  object Map extends Item(WallStorageFour2.floor, ap = None, noun = new SingularNoun("map"), pp = None)
  object Locket extends Item(CenterPedestal.top, ap = None, noun = new SingularNoun("locket"), pp = None)
}
