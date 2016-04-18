package game

abstract class RoomObject(art: String, str: String, ap: Option[String]) extends Noun(str, art, ap: Option[String]) with Describable

object RoomObject {
  class Cabinet(val drawers: List[Drawer]) extends RoomObject("cabinet", "a", None) {
    def drawerAmt = Drawer.withNumber(drawers.size)
    def describe = this.withArticle + " with " + drawerAmt
  }
}