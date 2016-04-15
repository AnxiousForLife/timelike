package game.main

import scala.collection.mutable

import game.assets._
import game.Direction._
import game.engine.Engine
import game.Item
import game.GameState

object Main {
  def main(args: Array[String]) {
    val startRoom = RoomTwelve
    val startDirection = North
    val startInventory = mutable.Set.empty[Item]
    val startState = new GameState(Seq((startRoom, startDirection)), startRoom, startDirection, startInventory)

    val engine = new Engine(startState)

    engine.gameLoop()
  }
}