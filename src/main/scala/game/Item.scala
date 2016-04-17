package game

import game.util.Noun

class Item(str: String, art: String) extends Noun(str, art)

class Key(str: String, art: String) extends Item(str, art)
