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

  def enterRoom(door: Door) = {
    //Is the player moving clockwise?/Does the player change direction in the next room?
    (room.outwardFace == direction.left.left, door) match {
      case (true, _: AngledDoor) => {
        updateRoom(door.room2)
        updateDirection(direction.right)
      }
      case (false, _: AngledDoor) => {
        updateRoom(door.room1)
        updateDirection(direction.left)
      }
      case (true, _) => updateRoom(door.room2)
      case (false, _) => updateRoom(door.room1)
    }
  }

  def lastState() = {
    log = log.dropRight(1)
    room = log.last._1
    direction = log.last._2
  }
}