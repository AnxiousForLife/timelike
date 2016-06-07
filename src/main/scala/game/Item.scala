package game

import scala.collection.mutable

import game.syntaxEn.{AdjectivePhrase, CountableNoun, PrepositionalPhrase}
import game.syntaxEn.Determiner._
import game.syntaxEn.Noun
import game.syntaxEn.Noun._
import game.syntaxEn.NounPhrase
import game.syntaxEn.Preposition._
import game.syntaxEn.Pronoun._

class Item(var location: ItemLocation,
           override val ap: Option[AdjectivePhrase],
           override val noun: CountableNoun,
           override val pp: Option[PrepositionalPhrase]) extends ConcreteArgument(ap, noun, pp) {
  def place(l: ItemLocation) = { location = l }
  def take() = place(Inventory)

  Item.update(this)
}

object Item {
  var list = mutable.Set.empty[Item]

  def update(i: Item) { list += i }

  def lookup(input: String): Item = {
    val results = list.filter(_.lexeme.lemma == input)
    assert(results.size <= 1)
    results.head
  }
}

class Key(location: ItemLocation,
          override val ap: Option[AdjectivePhrase],
          override val pp: Option[PrepositionalPhrase]) extends Item(location, ap, new CountableNoun("key"), pp)

object Key {
  def numeral(n: Int) =
    new PrepositionalPhrase(With,
      new NounPhrase(Some(A), Some(NumeralNoun.toAp), Noun.numeral(n), Some(new PrepositionalPhrase(On, It.toNp))))
}