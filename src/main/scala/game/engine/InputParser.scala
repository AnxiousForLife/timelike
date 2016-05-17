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

  def parseAction(string: String): PlayerAction = {
    val reader = new CharSequenceReader(string)
    command(reader) match {
      case Success(c: Command, input: Input) => {
        c match {
          //Turns
          case SimpleCommand("left") => new Turn(Left)
          case SimpleCommand("right") => new Turn(Right)
          case TargetedCommand("turn", x) => new Turn(Argument.lookup(x))

          //Opening things
          case SimpleCommand("open") => new Open(None)
          case TargetedCommand("open", x) => new Open(Some(Argument.lookup(x)))

          case SimpleCommand("take") => TakeItem
          case TargetedCommand("take", x) => TakeItem

          //Searching through things
          case SimpleCommand("search") => new StartSearch(None)
          case TargetedCommand("search", x) => new StartSearch(Some(Argument.lookup(x)))

          case SimpleCommand("rewind") => Rewind

          case _ => InvalidAction
        }
      }
      case Failure(msg, _) => InvalidAction
      case Error(msg, _) => InvalidAction
    }
  }

  def parseSearchAction(string: String): PlayerAction = {
    val reader = new CharSequenceReader(string)
    command(reader) match {
      case Success(c: Command, input: Input) => {
        if (input == "") c match {
          //Stopping the search
          case SimpleCommand("exit" | "leave" | "close" | "stop" | "quit") => StopSearch

          //Navigating drawers
          case SimpleCommand("prev" | "previous") | TargetedCommand("previous" | "prev", "drawer") => PrevDrawer
          case SimpleCommand("next") | TargetedCommand("next", "drawer") => PrevDrawer
        }
        else InvalidAction
      }
      case Failure(msg, _) => InvalidAction
      case Error(msg, _) => InvalidAction
    }
  }
}