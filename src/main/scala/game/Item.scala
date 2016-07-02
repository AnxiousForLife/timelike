package game

import game.PlayerAction.Unlock
import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Noun._
import game.syntaxEn.Preposition._
import game.syntaxEn.Pronoun._
import game.syntaxEn.Verb.Lie

abstract class Item(var location: ItemLocation,
           val useAction: PlayerAction,
           override val noun: CountableNoun) extends ConcreteArgument(noun) {
  override val stativeVerb: Verb = Lie

  def place(l: ItemLocation) = { location = l }
  def take() = place(Inventory)
}

abstract class Key(location: ItemLocation)
  extends Item(location, Unlock(None), new CountableNoun("key"))