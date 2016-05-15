package game

abstract class RoomObject extends Describable

object RoomObject {
  class Cabinet(val drawers: List[Drawer]) extends RoomObject with Container {
    def drawerAmt = Drawer.withNumber(drawers.size)
    def describe = Cabinet.withArticle + " with " + drawerAmt
  }

  object Cabinet extends Noun("cabinet", "a", None) with Openable with Searchable
}