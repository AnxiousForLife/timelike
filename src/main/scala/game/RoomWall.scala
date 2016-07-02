package game

import game.syntaxEn.Noun.FloorNoun
import game.syntaxEn.Preposition._

class RoomWall(val door: Option[Doorway], val arguments: Seq[ConcreteArgument]) {
  val floor = new ItemLocation(On, FloorNoun)
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