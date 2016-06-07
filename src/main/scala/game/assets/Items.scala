package game.assets

import game.syntaxEn.CountableNoun
import game.syntaxEn.Determiner._
import game.{Inventory, Item}

object Items {
  object Compass extends Item(Inventory, None, new CountableNoun("compass"), None)
  object Watch extends Item(Inventory, None, new CountableNoun("watch"), None)
}
