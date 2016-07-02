package game

import game.syntaxEn.Article.The
import game.syntaxEn._
import game.syntaxEn.Noun.{BookcaseNoun, PocketNoun, TopNoun}
import game.syntaxEn.Preposition._
import game.syntaxEn.Pronoun.You

//Anywhere an Item can be
class ItemLocation(val p: Preposition, val n: Noun) {
  def dp = The.quickDP(n)
  def pp = p.newPP(dp)
}

class Top(val a: ConcreteArgument) extends ItemLocation(On, TopNoun)

class Interior(val a: ConcreteArgument) extends ItemLocation(Inside, a.noun)

object Inventory extends ItemLocation(In, PocketNoun) {
  override def pp = p.newPP(You.dependentPossessive.quickDP(n))

  def contains(i: Item): Boolean = i.location == this
}

object Undefined extends ItemLocation(In, BookcaseNoun)