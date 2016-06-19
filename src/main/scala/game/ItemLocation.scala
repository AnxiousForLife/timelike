package game

import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition._

//Anywhere an Item can be
class ItemLocation(p: Preposition, np: SingularNounPhrase) {
  def toPp = new PrepositionalPhrase(p, np)
  def toN = np
}

class Top(val a: ConcreteArgument)
  extends ItemLocation(
    On, new SingularNounPhrase(None, None, new Noun("top"),
      Some(new PrepositionalPhrase(Of, new SingularNounPhrase(Some(The), a.ap, a.noun, a.pp))))) {
  override def toN = a.simpleThe
}

class Interior(val a: ConcreteArgument)
  extends ItemLocation(Inside, new SingularNounPhrase(Some(The), None, a.noun, None)) {
  override def toN = a.simpleThe
}

object Inventory extends ItemLocation(In, new SingularNounPhrase(Some(Your), None, new Noun("pocket"), None)) {
  def contains(i: Item): Boolean = i.location == this
}

object Undefined extends ItemLocation(In, new SingularNounPhrase(None, None, new Noun(""), None))