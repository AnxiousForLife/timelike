package game

abstract class Sandbag(override val noun: String,
                       override val art: String,
                       override val adj: Option[String],
                       location: ItemLocation,
                       capacity: Int) extends Item(noun, art, adj, location) {
  var amt: Int

  def remaining = capacity - amt
  def fill = { amt = capacity }
  def empty = { amt = 0 }
  def receiveAmt(x: Int) = { amt = capacity.min(x)}
  def pourInto(bag2: Sandbag) = {
    val diff = amt.min(bag2.remaining)
    amt -= diff
    bag2.amt += diff
  }
}
