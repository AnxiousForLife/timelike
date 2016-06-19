package game

import game.syntaxEn._
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition._

class RoomWall(val door: Option[Doorway], val arguments: Seq[ConcreteArgument]) {
  val floor = new ItemLocation(On, new SingularNounPhrase(Some(The), None, new Noun("floor"), None))
  val objective: Option[Objective] = None

  def availArguments: Seq[ConcreteArgument] = arguments.filter(_.isAvailable)

  def availLocations: Seq[ItemLocation] = availArguments.flatMap(_.availLocations) :+ floor

  def availOpenables: Seq[ConcreteArgument with Openable] = {
    var openables = Seq.empty[ConcreteArgument with Openable]
    door match {
      case Some(d: Door) => openables = openables :+ d
      case _ => {}
    }
    availArguments.filter(_.isInstanceOf[Openable]) ++ openables
    openables
  }

  def availSwitches: Seq[PullChain] = {
    var switches = Seq.empty[PullChain]
    for (x <- availArguments) x match {
      case l: PullChain => switches = switches :+ l
      case _ => {}
    }
    switches
  }
}