package game

import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition._

class RoomWall(val door: Option[Doorway], val arguments: Seq[ConcreteArgument]) {
  val floor = new ItemLocation(On, new SingularNounPhrase(Some(The), None, new Noun("floor"), None))
  val objective: Option[Objective] = None

  def availArguments: Seq[Argument] = door.toSeq ++ arguments ++ availItems :+ RelativeDirection.Left :+ RelativeDirection.Right

  def availItems: Seq[Item] = Item.list.filter(x => availLocations.contains(x.location)).toSeq

  def availLocations: Seq[ItemLocation] = {
    var locations = Seq[ItemLocation](floor)
    for (x <- arguments) x match {
      case c: Container => if(c.state == Opened) locations = locations :+ c.interior
      case _ => {}
    }
    locations
  }

  def availOpenables: Seq[ConcreteArgument with Openable] = {
    var openables = Seq.empty[ConcreteArgument with Openable]
    door match {
      case Some(d: Door) => openables = openables :+ d
      case _ => {}
    }
    for (x <- arguments) x match {
      case o:  Openable => openables = openables :+ o
      case _ => {}
    }
    openables
  }

  def availLevers: Seq[PullChain] = {
    var levers = Seq.empty[PullChain]
    for (x <- arguments) x match {
      case l: PullChain => levers = levers :+ l
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