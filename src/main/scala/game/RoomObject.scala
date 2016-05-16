package game

abstract class RoomObject(override val noun: String,
                          override val art: String,
                          override val adj: Option[String],
                          var location: ItemLocation) extends Noun(noun, art, adj)

object RoomObject {
  class Cabinet extends RoomObject with ItemLocation

  object Cabinet extends Noun("cabinet", "a", None) with Searchable
}