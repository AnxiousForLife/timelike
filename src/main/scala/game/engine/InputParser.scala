package game.engine

import game.{ArgumentResult, GameState, PlayerAction, RoomWall}
import game.PlayerAction._
import game.RelativeDirection._
import game.syntaxEn._
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

  /*val the: Parser[Determiner] = "the" ^^^ The
  val a: Parser[Determiner] = "a" ^^^ A
  val an: Parser[Determiner] = "an" ^^^ An

  val against: Parser[Preposition] = "against" ^^^ Against
  val before: Parser[Preposition] = "before" ^^^ Before
  val from: Parser[Preposition] = "from" ^^^ From
  val in: Parser[Preposition] = "in" ^^^ In
  val inside: Parser[Preposition] = "inside" ^^^ Inside
  val of: Parser[Preposition] = "of" ^^^ Of
  val on: Parser[Preposition] = "on" ^^^ On
  val through: Parser[Preposition] = "through" ^^^ Through
  val upon: Parser[Preposition] = "upon" ^^^ Upon

  val determiner: Parser[Determiner] = the | a | an

  val preposition: Parser[Preposition] = against | before | from | in | inside | of | on | through | upon

  lazy val adjectivePhrase = word ^^ {
    case a => new AdjectivePhrase(new Adjective(a))
  }

  lazy val prepositionalPhrase: Parser[PrepositionalPhrase] = preposition ~ nounPhrase ^^ {
    case p ~ n => new PrepositionalPhrase(p, n)
  }

  lazy val nounPhrase = (determiner ?) ~ (adjectivePhrase ?) ~ word ~ (prepositionalPhrase ?) ^^ {
    case det ~ ap ~ n ~ pp => new SingularNounPhrase(det, ap, new Noun(n), pp)
  }*/

  val simple: Parser[IntransitiveCommand] = word ^^ (x => IntransitiveCommand(x))

  val targeted: Parser[TransitiveCommand] = word ~ word ^^ {
    case verb ~ obj => TransitiveCommand(verb, obj)
  }

  val prepositional: Parser[DitransitiveCommand] = word ~ word ~ word ^^ {
    case verb ~ obj1 ~ obj2 => DitransitiveCommand(verb, obj1, obj2)
  }

  val command: Parser[Command] = commit(targeted | simple)

  def parseAction(string: String, state: GameState): PlayerAction = {
    val reader = new CharSequenceReader(string)
    command(reader) match {
      case Success(c: Command, input: Input) => {
        c match {
          case IntransitiveCommand("examine") => new Examine(None)
          case TransitiveCommand("examine", x) => new Examine(Some(state.lookup(x)))

          case IntransitiveCommand("left") => new Turn(Some(new ArgumentResult(Left)))
          case IntransitiveCommand("right") => new Turn(Some(new ArgumentResult(Right)))
          case IntransitiveCommand("turn") => new Turn(None)
          case TransitiveCommand("turn", x) => new Turn(Some(state.lookup(x)))

          case IntransitiveCommand("open") => new Open(None)
          case TransitiveCommand("open", x) => new Open(Some(state.lookup(x)))

          case IntransitiveCommand("close") => new Close(None)
          case IntransitiveCommand("shut") => new Close(None)
          case TransitiveCommand("close", x) => new Close(Some(state.lookup(x)))
          case TransitiveCommand("shut", x) => new Close(Some(state.lookup(x)))

          case IntransitiveCommand("unlock") => new Unlock(None)
          case TransitiveCommand("unlock", x) => new Unlock(Some(state.lookup(x)))

          case IntransitiveCommand("enter") => new Enter(None)
          case IntransitiveCommand("exit") => new Enter(None)
          case IntransitiveCommand("go") => new Enter(None)
          case IntransitiveCommand("walk") => new Enter(None)
          case TransitiveCommand("enter", x) => new Enter(Some(state.lookup(x)))
          case TransitiveCommand("exit", x) => new Enter(Some(state.lookup(x)))

          case IntransitiveCommand("take") => new TakeItem(None)
          case TransitiveCommand("take", x) => new TakeItem(Some(state.lookup(x)))
          case IntransitiveCommand("place") => new PlaceItem(None)
          case TransitiveCommand("place", x) => new PlaceItem(Some(state.lookup(x)))
          case IntransitiveCommand("drop") => new PlaceItem(None)
          case TransitiveCommand("drop", x) => new PlaceItem(Some(state.lookup(x)))

          case IntransitiveCommand("use") => new UseItem(None)
          case TransitiveCommand("use", x) => new UseItem(Some(state.lookup(x)))

          case IntransitiveCommand("pull") => new Pull(None)
          case TransitiveCommand("pull", x) => new Pull(Some(state.lookup(x)))

          case IntransitiveCommand("rewind") => Rewind

          case _ => InvalidAction
        }
      }
      case Failure(msg, _) => InvalidAction
      case Error(msg, _) => InvalidAction
    }
  }
}