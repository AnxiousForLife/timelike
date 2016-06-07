package game

import game.syntaxEn._
import game.syntaxEn.Adjective._
import game.syntaxEn.Noun._
import game.syntaxEn.Preposition._

//Connector for two Rooms
class Doorway(val room1: Room,
              val room2: Room,
              override val ap: Option[AdjectivePhrase],
              override val noun: CountableNoun,
              override val pp: Option[PrepositionalPhrase])
  extends ConcreteArgument(ap, noun, pp)

class Door(override val room1: Room,
           override val room2: Room,
           override val ap: Option[AdjectivePhrase],
           override val noun: CountableNoun,
           override val pp: Option[PrepositionalPhrase]) extends Doorway(room1, room2, ap, noun, pp)
  with Openable

class SingleDoor(override val room1: Room,
                 override val room2: Room,
                 override val ap: Option[AdjectivePhrase],
                 override val pp: Option[PrepositionalPhrase]) extends Door(room1, room2, ap, DoorNoun, pp)

class DoorPair(override val room1: Room,
               override val room2: Room) extends Door(room1, room2, None, PairNoun,
  Some(new PrepositionalPhrase(Of, new NounPhrase(None, Some(IronAdj.toAp), DoorNoun.plural, None))))

class ConcealedDoor(override val room1: Room,
                    override val room2: Room,
                    override val ap: Option[AdjectivePhrase],
                    override val pp: Option[PrepositionalPhrase]) extends Door(room1, room2, ap, BookcaseNoun, pp)

class BalconyWalkway(override val room1: Room,
                     override val room2: Room)
  extends Doorway(room1, room2, None, new CountableNoun("balcony"), None)

