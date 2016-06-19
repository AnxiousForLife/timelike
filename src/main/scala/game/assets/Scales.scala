package game.assets

import game.{Scale, Raised}
import game.assets.Doors.DoorThreeFour

object Scales {
  object Scale3 extends Scale(10, DoorThreeFour, Raised)

  val list = Seq(Scale3)
}
