package game

import game.syntaxEn._

class RoomWall(val door: Option[Door], val arguments: Seq[ConcreteArgument]) extends ItemLocation {
  val lPreposition = Some(On)
  val lNoun = Some(new CountableNoun("floor"))

  def availArguments: Seq[Argument] = door.toSeq ++ arguments ++ availItems :+ RelativeDirection.Left :+ RelativeDirection.Right

  def availItems: Seq[Item] = Item.list.filter(x => availLocations.contains(x.location)).toSeq

  def availLocations: Seq[ItemLocation] = {
    val locations = Seq[ItemLocation](this)
    for (x <- arguments) x match {
      case o: ItemLocation with Openable => if(o.state == Opened) locations :+ o
      case _ => {}
    }
    locations
  }

  def availOpenables: Seq[Openable] = {
    val openables = door.toSeq
    for (x <- arguments) x match {
      case o:  Openable => openables :+ o
      case _ => {}
    }
    openables
  }

  def availLevers: Seq[Lever] = {
    var levers = Seq.empty[Lever]
    for (x <- arguments) x match {
      case l: Lever => levers = levers :+ l
      case _ => {}
    }
    levers
  }

  def lookup(input: String) = {
    val results = availArguments.filter(_.lexeme.lemma == input)
    assert(results.size <= 1) //***ASSUMES ONLY ONE ARGUMENT OF A CERTAIN NAME WILL BE AVAILABLE AT A TIME***
    results.headOption.getOrElse(new DummyArgument(new Lexeme(input)))
  }
}