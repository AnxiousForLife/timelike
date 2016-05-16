package game

sealed trait OpenState
object Closed extends OpenState
object Opened extends OpenState

//Anything that can be opened
trait Openable {
  var state: OpenState = Closed

  def open() { state = Opened }
  def close() { state = Closed}

  def isOpen = state == Opened
}