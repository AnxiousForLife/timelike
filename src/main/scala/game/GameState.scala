package game

import scala.collection.mutable

//The game state, containing a log of all the past player locations and the current player location
class GameState(var log: Seq[(Room, Direction)], var room: Room, var direction: Direction, var inventory: mutable.Set[Item]) {
  def currentWall = room.currentWall(direction)

  def updateLog() { log :+= (room, direction) }
  def updateRoom(newRoom: Room) = {
    room = newRoom
    updateLog
  }
  def updateDirection(newDirection: Direction) = {
    direction = newDirection
    updateLog()
  }
  def addItem(x: Item) = inventory += x
  def removeItem(x: Item) = inventory -= x

  def lastState() = {
    log = log.dropRight(1)
    room = log.last._1
    direction = log.last._2
  }
}