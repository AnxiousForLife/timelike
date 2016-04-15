package game

import scala.collection.mutable

//The game state, containing a log of all the past player locations and the current player location
class GameState(var log: Seq[(Room, Direction)], var room: Room, var direction: Direction, var inventory: mutable.Set[Item]) {
  def updateLog(room: Room, direction: Direction) { log :+= (room, direction) }
  def updateRoom(newRoom: Room) = {
    updateLog(newRoom, direction)
    room = newRoom
  }
  def updateDirection(newDirection: Direction) = {
    updateLog(room, newDirection)
    direction = newDirection
  }
  def addItem(x: Item) = inventory += x
  def removeItem(x: Item) = inventory -= x

  def lastState() = {
    log = log.dropRight(1)
    room = log.last._1
    direction = log.last._2
  }
}