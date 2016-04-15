package game

class Item(art: String, str: String) {
  override def toString() = art + " " + str
}

class Key(art: String, str: String) extends Item(art, str)
