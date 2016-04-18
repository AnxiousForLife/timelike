package game

class Item(str: String, art: String, ap: Option[String]) extends Noun(str, art, ap)

class Key(str: String, art: String, ap: Option[String]) extends Item(str, art, ap)