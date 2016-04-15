package game

class Item(str: String) {
  override def toString() = str
}

class Key(str: String) extends Item(str)
