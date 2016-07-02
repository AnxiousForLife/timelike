package game.assets

import game.{Marble, Pedestal}
import game.syntaxEn.Adjective.MarbleAdj

object Pedestals {
  object CenterPedestal extends Pedestal {
    val relSize = None
    val material = Some(Marble)
    val image = None
    val text = None
  }
}