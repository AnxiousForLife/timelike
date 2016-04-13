package game

//The game state, containing a log of all the past player locations and the current player location
class GameState(val log: Seq[(Room, Direction)], val room: Room, val direction: Direction, val inventory: Set[Item], val doorLocks: Map[Doorway, LockType]) {
  def updateLog(room: Room, direction: Direction) = log :+ (room, direction)
  def updateRoom(newRoom: Room) = new GameState(updateLog(newRoom, direction), newRoom, direction, inventory, doorLocks)
  def updateDirection(newDirection: Direction) = new GameState(updateLog(room, newDirection), room, newDirection, inventory, doorLocks)
  def addItem(x: Item) = new GameState(log, room, direction, inventory + x, doorLocks)
  def removeItem(x: Item) = new GameState(log, room, direction, inventory - x, doorLocks)
  def addLock(d: Doorway, s: LockType) = new GameState(log, room, direction, inventory, doorLocks + (d -> s))
  def removeLock(x: Doorway) = new GameState(log, room, direction, inventory, doorLocks - x)

  def lastState = {
    val lastLog = log.dropRight(1)
    val lastRoom = lastLog.last._1
    val lastDirection = lastLog.last._2
    new GameState(lastLog, lastRoom, lastDirection, inventory, doorLocks)
  }
}