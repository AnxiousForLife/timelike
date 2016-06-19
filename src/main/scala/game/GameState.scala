package game

import game.syntaxEn.{Lexeme, Noun}

sealed trait LookupResult
class ArgumentResult(val arg: Argument) extends LookupResult
class AmbiguousResult(val args: Seq[Argument]) extends LookupResult

//The game state, containing a log of all the past player locations and the current player location
class GameState(var log: Seq[(Room, Direction)], var room: Room, var direction: Direction, val items: Seq[Item]) extends Argument(new Noun("game")) {
  def currentWall = room.dirToWall(direction)

  def updateLog() { log :+= (room, direction) }
  def updateRoom(newRoom: Room) = {
    room = newRoom
    updateLog()
  }
  def updateDirection(newDirection: Direction) = {
    direction = newDirection
    updateLog()
  }

  def turn(rd: Any) = updateDirection(direction.turn(rd.asInstanceOf[RelativeDirection]))

  def enterRoom(doorway: Doorway) = {
    val orientation = room.orientations(direction)
    val nextRoom = doorway.nextRoom(room)
    val newDirection = nextRoom.directions(orientation)

    updateDirection(newDirection)
    updateRoom(nextRoom)
  }

  def itemsAtLocation(l: ItemLocation): Seq[Item] = items.filter(_.location == l)

  def allAvailArguments: Seq[Argument] = currentWall.door.toSeq ++ currentWall.availArguments ++ availItems :+ RelativeDirection.Left :+ RelativeDirection.Right

  def availItems: Seq[Item] = items.filter(x => currentWall.availLocations.contains(x.location))

  def lookup(input: String): LookupResult = {
    val results = (allAvailArguments ++ itemsAtLocation(Inventory)).filter(_.lexeme.lemma == input)
    if (results.size <= 1) {
      val arg = results.headOption.getOrElse(new DummyArgument(new Lexeme(input)))
      new ArgumentResult(arg)
    }
    else new AmbiguousResult(results)
  }

  def lastState() = {
    log = log.dropRight(1)
    room = log.last._1
    direction = log.last._2
  }
}