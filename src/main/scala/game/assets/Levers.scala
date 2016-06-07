package game.assets

import game.Lever
import game.LeverState._
import game.assets.Doors._

object Levers {
  object ClosetLever extends Lever(Up, "flowery vine", ClosetAccessDoor, ClosetDoor)
  object Lever11 extends Lever(Up, "thorned vine", DoorTenEleven, DoorNineTen)
  object Lever9 extends Lever(Up, "snake skeleton", DoorTenEleven, DoorNineTen)
  object Lever6 extends Lever(Up, "serpent", DoorSixSeven, DoorSixAccess)
  object CenterAccessLever extends Lever(Up, "", DoorMidAccess, DoorCenterAccess)
}
