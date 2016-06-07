package game

import game.syntaxEn.{AdjectivePhrase, CountableNoun, PrepositionalPhrase}

class Container(override val noun: CountableNoun,
                override val ap: Option[AdjectivePhrase],
                override val pp: Option[PrepositionalPhrase]) extends ConcreteArgument(ap, noun, pp) with Openable {
  val interior = new Interior(this)

  def contents: Seq[Item] = Item.list.filter(_.location == interior).toSeq
}