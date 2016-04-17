package game

import game.util.{ Describable, Noun }

abstract class RoomObject(art: String, str: String) extends Noun(str, art) with Describable

object RoomObject {
  class Cabinet(val drawers: List[Drawer]) extends RoomObject("cabinet", "a") {
    def drawerAmt = Drawer.withNumber(drawers.size)
    def describe = this.withArticle + " with " + drawerAmt
  }
}