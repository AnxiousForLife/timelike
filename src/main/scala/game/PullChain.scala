package game

import game.LockState.{Barred, Unlocked}
import game.syntaxEn.Article.ZeroArticle
import game.syntaxEn.Verb.{Engrave, Hang}
import game.syntaxEn.{CountableNoun, Noun}

sealed trait LeverState

object LeverState {
  object Up extends LeverState
  object Down extends LeverState
}

abstract class PullChain(var state: LeverState,
                val symbol: String, //Levers and door bars are engraved with matching symbols
                door1: Door,
                door2: Door) extends ConcreteArgument(new CountableNoun("pull chain")) {
  import game.LeverState._

  val relSize = None
  val material = None
  val image = Some(new Image(ZeroArticle, new Noun(symbol), Engrave))
  val text = None

  override val stativeVerb = Hang
  //override val locationPp: PrepositionalPhrase = new PrepositionalPhrase(From, CeilingNoun.withDefinite)

  def pull() = {
    state match {
      case Up => state = Down
      case Down => state = Up
    }
    update()
  }

  def update() = {
    state match {
      case Up => door1.lock = Unlocked; door2.lock = bars
      case Down => door1.lock = bars; door2.lock = Unlocked
    }
  }

  val bars = new Barred(symbol)

  update()
}
