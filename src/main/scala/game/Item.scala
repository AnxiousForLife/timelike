package game

sealed class Item(str: String) {
  override def toString() = str
}

object Compass extends Item("compass")
object Watch extends Item("watch")

class Key(str: String) extends Item(str)
