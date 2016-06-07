package game

import game.syntaxEn.Noun

//The game state, containing a log of all the past player locations and the current player location
class GameState(var log: Seq[(Room, Direction)], var room: Room, var direction: Direction) extends Argument(new Noun("game")) {
  def currentWall = room.currentWall(direction)

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
    val newRoom = {
      if (room == doorway.room1) doorway.room2
      else doorway.room1
    }
    val newDirection = newRoom.directions(orientation)

    updateDirection(newDirection)
    updateRoom(newRoom)
  }

  def lastState() = {
    log = log.dropRight(1)
    room = log.last._1
    direction = log.last._2
  }
}