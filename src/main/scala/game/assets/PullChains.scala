package game.assets

import game.PullChain
import game.LeverState._
import game.assets.Doors._

object PullChains {
  object ClosetPullChain extends PullChain(Up, "flowery vine", ClosetAccessDoor, ClosetDoor)
  object PullChain11 extends PullChain(Up, "thorned vine", DoorTenEleven, DoorNineTen)
  object PullChain9 extends PullChain(Up, "snake skeleton", DoorTenEleven, DoorNineTen)
  object PullChain6 extends PullChain(Up, "serpent", DoorSixSeven, DoorSixAccess)
  object CenterAccessPullChain extends PullChain(Up, "ocean wave", DoorMidAccess, DoorCenterAccess)
}
