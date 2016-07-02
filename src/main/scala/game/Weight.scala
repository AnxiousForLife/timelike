package game

import game.PlayerAction.InvalidAction
import game.syntaxEn.Verb.Sit
import game.syntaxEn._

class Weight(location: ItemLocation, weight: Int)
  extends Item(location, InvalidAction, new CountableNoun("weight")) {

  val relSize = Some(Small)
  val material = Some(Lead)
  val image = None
  val text = Some(new Writing(weight.toString))

  override val stativeVerb: Verb = Sit
}
