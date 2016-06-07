package game.engine

import game.{PlayerAction, RoomWall}
import game.PlayerAction._
import game.RelativeDirection._

import game.syntaxEn.Determiner
import game.syntaxEn.Determiner._
import game.syntaxEn.Preposition._

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.input.CharSequenceReader

sealed trait Command

final case class IntransitiveCommand(verb: String) extends Command

final case class TransitiveCommand(verb: String, obj: String) extends Command

final case class DitransitiveCommand(verb: String, obj1: String, obj2: String) extends Command

object InputParser extends RegexParsers {
  val word: Parser[String] = """[a-zA-Z]+""".r

  /*val the: Parser[The] = "the" ^^^ The
  val a: Parser[A] = "a" ^^^ A
  val an: Parser[An] = "an" ^^^ An

  val determiner: Parser[Determiner] = the | a | an

  lazy val nounPhrase = (determiner ?) (adjectivePhrase ?)  noun ~ (prepositionalPhrase ?) ^^ {}*/

  val simple: Parser[IntransitiveCommand] = word ^^ (x => IntransitiveCommand(x))

  val targeted: Parser[TransitiveCommand] = word ~ word ^^ {
    case verb ~ obj => TransitiveCommand(verb, obj)
  }

  val prepositional: Parser[DitransitiveCommand] = word ~ word ~ word ^^ {
    case verb ~ obj1 ~ obj2 => DitransitiveCommand(verb, obj1, obj2)
  }

  val command: Parser[Command] = commit(targeted | simple)

  def parseAction(string: String, roomWall: RoomWall): PlayerAction = {
    val reader = new CharSequenceReader(string)
    command(reader) match {
      case Success(c: Command, input: Input) => {
        c match {
          case IntransitiveCommand("examine") => new Examine(None)
          case TransitiveCommand("examine", x) => new Examine(Some(roomWall.lookup(x)))

          //Turns
          case IntransitiveCommand("left") => new Turn(Some(Left))
          case IntransitiveCommand("right") => new Turn(Some(Right))
          case IntransitiveCommand("turn") => new Turn(None)
          case TransitiveCommand("turn", x) => new Turn(Some(roomWall.lookup(x)))

          //Opening things
          case IntransitiveCommand("open") => new Open(None)
          case TransitiveCommand("open", x) => new Open(Some(roomWall.lookup(x)))

          //Closing things
          case IntransitiveCommand("close") => new Close(None)
          case IntransitiveCommand("shut") => new Close(None)
          case TransitiveCommand("close", x) => new Close(Some(roomWall.lookup(x)))
          case TransitiveCommand("shut", x) => new Close(Some(roomWall.lookup(x)))

          //Unlocking things
          case IntransitiveCommand("unlock") => new Unlock(None)
          case TransitiveCommand("unlock", x) => new Unlock(Some(roomWall.lookup(x)))

          //Entering rooms
          case IntransitiveCommand("enter") => new Enter(None)
          case IntransitiveCommand("exit") => new Enter(None)
          case IntransitiveCommand("go") => new Enter(None)
          case IntransitiveCommand("walk") => new Enter(None)
          case TransitiveCommand("enter", x) => new Enter(Some(roomWall.lookup(x)))
          case TransitiveCommand("exit", x) => new Enter(Some(roomWall.lookup(x)))

          //Taking items
          case IntransitiveCommand("take") => new TakeItem(None)
          case TransitiveCommand("take", x) => new TakeItem(Some(roomWall.lookup(x)))

          //Placing items
          case IntransitiveCommand("place") => new PlaceItem(None, None)
          case TransitiveCommand("place", x) => new PlaceItem(Some(roomWall.lookup(x)), None)
          case DitransitiveCommand("place", x, y) => new PlaceItem(Some(roomWall.lookup(x)), Some(roomWall.lookup(y)))

          //Pulling levers
          case IntransitiveCommand("pull") => new Pull(None)
          case TransitiveCommand("pull", x) => new Pull(Some(roomWall.lookup(x)))

          case IntransitiveCommand("rewind") => Rewind

          case _ => InvalidAction
        }
      }
      case Failure(msg, _) => InvalidAction
      case Error(msg, _) => InvalidAction
    }
  }
}