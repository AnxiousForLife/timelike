package game

import game.syntaxEn.CountableNoun

abstract class Container(override val noun: CountableNoun) extends ConcreteArgument(noun) with Openable {
  //override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(Against, WallNoun.withDefinite)

  val interior = new Interior(this)

  override val locations: Seq[ItemLocation] = Seq()
  override def availLocations: Seq[ItemLocation] = {
    if (isOpen)
      interior +: locations
    else
      Seq.empty[ItemLocation]
  }
}