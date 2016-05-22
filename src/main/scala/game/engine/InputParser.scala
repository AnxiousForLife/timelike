package game.engine

import game.Argument
import game.PlayerAction
import game.PlayerAction._
import game.RelativeDirection._

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.input.CharSequenceReader

sealed trait Command

final case class SimpleCommand(verb: String) extends Command

final case class TargetedCommand(verb: String, obj: String) extends Command

//final case class PrepositionalCommand(verb: String, obj: String, prep: String, prepObj: String) extends Command

object InputParser extends RegexParsers {
  val word: Parser[String] = """[a-zA-Z]+""".r

  val simple: Parser[SimpleCommand] = word ^^ (x => SimpleCommand(x))

  val targeted: Parser[TargetedCommand] = word ~ word ^^ {
    case verb ~ obj => TargetedCommand(verb, obj)
  }

  /*val prepositional: Parser[PrepositionalCommand] = word ~ word ~ word ~ word ^^ {
    case verb ~ obj ~ prep ~ prepObj => PrepositionalCommand(verb, obj, prep, prepObj)
  }*/

  val command: Parser[Command] = commit(/*prepositional | */ targeted | simple)

  def parseAction(string: String): (PlayerAction, Option[Argument]) = {
    val reader = new CharSequenceReader(string)
    command(reader) match {
      case Success(c: Command, input: Input) => {
        c match {
          //Turns
          case SimpleCommand("left") => (Turn, Some(Left))
          case SimpleCommand("right") => (Turn, Some(Right))
          case SimpleCommand("turn") => (Turn, None)
          case TargetedCommand("turn", x) => (Turn, Some(Argument.lookup(x)))

          //Opening things
          case SimpleCommand("open") => (Open, None)
          case TargetedCommand("open", x) => (Open, Some(Argument.lookup(x)))

          case SimpleCommand("take") => (TakeItem, None)
          case TargetedCommand("take", x) => (TakeItem, Some(Argument.lookup(x)))

          case SimpleCommand("rewind") => (Rewind, None)

          case _ => (InvalidAction, None)
        }
      }
      case Failure(msg, _) => (InvalidAction, None)
      case Error(msg, _) => (InvalidAction, None)
    }
  }
}