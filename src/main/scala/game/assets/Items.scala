package game.assets

import game.syntaxEn.CountableNoun
import game.{Inventory, Item}

object Items {
  object Compass extends Item(new CountableNoun("compass"), None, None, Inventory)
  object Watch extends Item(new CountableNoun("watch"), None, None, Inventory)
}
