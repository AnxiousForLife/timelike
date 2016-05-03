package game

sealed trait OpenState
object Closed extends OpenState
object Opened extends OpenState

class Drawer extends Container {
  var state: OpenState = Closed

  def open() { state = Opened }
  def close() { state = Closed}

  def isOpen = state == Opened
}

object Drawer extends Noun("drawer", "a", None) with Openable with Searchable