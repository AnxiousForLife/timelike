package game

import util.Noun

class Item(art: String, str: String) extends Noun(str, art)

class Key(art: String, str: String) extends Item(art, str)
