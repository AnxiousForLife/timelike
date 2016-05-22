package game

//Anywhere an Item can be
trait ItemLocation

object Inventory extends ItemLocation {
  def contains(i: Item): Boolean = i.location == this
}