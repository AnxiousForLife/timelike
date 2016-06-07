package game

import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition._

//Anywhere an Item can be
class ItemLocation(p: Preposition, np: NounPhrase) {
  def toPp = new PrepositionalPhrase(p, np)
}

class Top(a: ConcreteArgument)
  extends ItemLocation(
    On, new NounPhrase(None, None, new Noun("top"),
      Some(new PrepositionalPhrase(Of, new NounPhrase(Some(The), a.ap, a.noun, a.pp)))))

class Interior(a: ConcreteArgument)
  extends ItemLocation(Inside, new NounPhrase(Some(The), a.ap, a.noun, a.pp))

object Inventory extends ItemLocation(In, new NounPhrase(Some(Your), None, new Noun("pocket"), None)) {
  def contains(i: Item): Boolean = i.location == this
}

object Undefined extends ItemLocation(In, new NounPhrase(None, None, new Noun(""), None)) {
  def contains(i: Item): Boolean = i.location == this
}