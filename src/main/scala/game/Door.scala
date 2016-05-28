package game

import game.syntaxEn.CountableNoun

//Connector for two Rooms, which are listed clockwise
class Door(val room1: Room,
           val room2: Room,
           lock: LockState,
           adj1: Option[String],
           adj2: Option[String]) extends Openable(new CountableNoun("door"), lock, adj1, adj2)

class AngledDoor(override val room1: Room,
                 override val room2: Room,
                 lock: LockState,
                 adj1: Option[String],
                 adj2: Option[String]) extends Door(room1, room2, lock, adj1, adj2)