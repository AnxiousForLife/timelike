package game

import game.syntaxEn.{Noun, _}
import game.syntaxEn.Adjective._
import game.syntaxEn.Article.ZeroArticle
import game.syntaxEn.Noun._
import game.syntaxEn.Preposition._
import game.syntaxEn.Verb.Stand

//Connector for two Rooms
abstract class Doorway(val room1: Room,
              val room2: Room,
              override val noun: CountableNoun)
  extends ConcreteArgument(noun) {
  val text = None
  val image = None

  override val stativeVerb = Stand
  //override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(Before, )

  def nextRoom(currentRoom: Room): Room = {
    currentRoom match {
      case `room1` => room2
      case `room2` => room1
    }
  }
}

abstract class Door(override val room1: Room,
           override val room2: Room,
           override val noun: CountableNoun) extends Doorway(room1, room2, noun)
  with Openable

abstract class SingleDoor(override val room1: Room,
                 override val room2: Room) extends Door(room1, room2, DoorNoun)

abstract class DoorPair(override val room1: Room,
               override val room2: Room) extends Door(room1, room2, DoorNoun) {
  override def describe(xps: Seq[Option[XP[_] with AdjunctOfNP]]): NP = {
    val doorsDP: DP = ZeroArticle.quickDP(noun)

    PairNoun.addComplement(Of.newPP(doorsDP)).addAdjunctOptions(xps)
  }
}

abstract class ConcealedDoor(override val room1: Room,
                    override val room2: Room) extends Door(room1, room2, BookcaseNoun) {
  val relSize = Some(Large)
  val material = Some(Wooden)

}

abstract class BalconyWalkway(override val room1: Room,
                     override val room2: Room)
  extends Doorway(room1, room2, new CountableNoun("balcony"))

