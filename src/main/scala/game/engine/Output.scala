package game.engine

import game.LockState.Barred
import game.{Argument, _}
import game.assets.Items.Compass
import game.assets.Title
import game.syntaxEn.CountableNoun
import game.util.ListStrings

import scala.Console.{BOLD, RESET}

object Output {
  def printIndent(s: String) = println("   " ++ s)

  def showTitle() = println(Title.str)

  def showReturnTitle() = {
    val returnText = "[PRESS ENTER (⏎)]"
    val spacesAmt = Title.width - returnText.length
    println(" " * spacesAmt ++ "[PRESS ENTER (⏎)]")
  }
  def showReturnShort() = println("(↵)")

  def showInvalid() = printIndent("That means nothing here.")

  def directionText(state: GameState): String = {
    if (Inventory.contains(Compass)) s"You face ${state.direction}."
    else ""
  }

  def fovText(state: GameState): String = {
    val doorText: String = {
      state.currentWall.door match {
        case None => ""
        case Some(doorway: Doorway) => {
          doorway match {
            case door: Door => {
              if (door.isOpen) "There's an open door before you."
              else {
                door.lock match {
                  case x: Barred => "There's " ++ door.npIndefinite.toString ++ " before you," +
                    s" but it's blocked by iron bars with images of ${new CountableNoun(x.symbol).plural} engraved on them."
                  case _ => "There's " ++ door.npIndefinite.toString ++ " before you."
                }
              }
            }
            case _: BalconyWalkway => "The path continues this way."
            case _ => "There's " ++ doorway.npIndefinite.toString ++ " before you."
          }
        }
      }
    }

    val argumentText: String = {
      (for (x <- state.currentWall.arguments) yield " There's " ++ x.show ++ ".").mkString(" ")
    }

    val itemsText: String = {
      state.currentWall.availItems match {
        case Nil => ""
        case items => {
          val stringList: Seq[String] = for (x <- items) yield x.npIndefinite.toString
          " There's " ++ ListStrings.listOr(stringList) ++ " here."
        }
      }
    }

    val allArguments: String = {
      val all = doorText ++ argumentText ++ itemsText
      all.length match {
        case 0 => "There's nothing before you."
        case _ => all
      }
    }

    allArguments.capitalize
  }

  def showRoom(state: GameState) = {
    val raw = {
      state.room match {
        case _: Room with Balcony => s"||-You stand outside on a balcony. ${fovText(state)}"
        case _ => s"||-${directionText(state)} You're in a ${state.room.description}. ${fovText(state)}"
      }
    }
    println("_" * raw.length + s"\n$raw")
  }

  def showFOV(state: GameState) = printIndent(directionText(state) ++ " " ++ fovText(state))

  def showFirstWalk() = printIndent(s"An urge to " + BOLD + "walk forward" + RESET + ".")

  def showContents(c: Container) = {
    val text = c.contents match {
      case Nil => s"${c.noun.withDefinite.toString.capitalize} is empty."
      case items => {
        val stringList: Seq[String] = for (x <- items) yield x.npIndefinite.toString
        val copula = if (stringList.length == 1) "is" else "are"
        s"Inside ${c.noun.withDefinite.toString} $copula " ++ ListStrings.listOr(stringList) ++ "."
      }
    }
    printIndent(text)
  }

  def showAmbiguousDirection() = {
    printIndent("But which way?")
  }

  def showNotADirection(a: Argument) = {
    printIndent(s""""$a" is not a direction.""")
  }

  def showTurn(rd: RelativeDirection) = {
    printIndent(s"You turn $rd.")
  }

  def showOpen(o: ConcreteArgument with Openable) = {
    printIndent(s"You open ${o.noun.withDefinite}.")
  }

  def showAlreadyOpened(o: ConcreteArgument with Openable) = {
    printIndent(s"${o.noun.withDefinite.toString.capitalize} is already open.")
  }

  def showCantOpen() = {
    printIndent("You can't open that.")
  }

  def showNoOpenable() = {
    printIndent(s"There's nothing here to open.")
  }

  //Prints a list of things the player can open if they don't specify what to open.
  def showAmbiguousOpen(openables: Seq[ConcreteArgument with Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite.toString
    val listOr = ListStrings.listOr(stringList)
    printIndent(s"You could open $listOr.")
  }

  def showClose(o: ConcreteArgument with Openable) = {
    printIndent(s"You close ${o.noun.withDefinite}.")
  }

  def showAlreadyClosed(o: ConcreteArgument with Openable) = {
    printIndent(s"${o.noun.withDefinite.toString.capitalize} is already closed.")
  }

  def showCantClose() = {
    printIndent("You can't open that.")
  }

  def showNoCloseable() = {
    printIndent(s"There's nothing here to close.")
  }

  def showAmbiguousClose(openables: Seq[ConcreteArgument with Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite.toString
    val listOr = ListStrings.listOr(stringList)
    printIndent(s"Could close $listOr.")
  }

  def showNoExit() {
    printIndent("There's no way to go here.")
  }

  def showEnterRoom(d: Doorway) {
    d match {
      case _: BalconyWalkway => printIndent("You walk along the balcony.")
      case _ => printIndent("You walk through the doorway.")
    }
  }

  def showDoorClosed() {
    printIndent("The door is closed.")
  }

  def showCantEnter() {
    printIndent("You can't enter that.")
  }

  def showNoItem() {
    printIndent("There's nothing here to take.")
  }

  //Prints a list of items the player can take if they don't specify what to take.
  def showAmbiguousTake(items: Seq[Item]) = {
    val stringList: Seq[String] = for (x <- items) yield x.noun.withDefinite.toString
    val listOr = ListStrings.listOr(stringList)
    printIndent(s"You could take $listOr.")
  }

  def showTakeItem(x: Item) {
    printIndent(s"You take the $x.")
  }

  def showUnavailableArgument() {
    printIndent(s"There's nothing like that here.")
  }

  def showCantTake() {
    printIndent(s"You can't take that.")
  }

  def showCantUnlock() {
    printIndent("You can't unlock that.")
  }

  def showKeyLocked(o: Openable) {
    o match {
      case _: DoorPair => printIndent("The doors are locked.")
      case _ => printIndent("The door is locked.")
    }

  }

  def showDoorBarred() {
    printIndent("The door is blocked by bars.")
  }

  def showUnlock(o: ConcreteArgument with Openable) {
    printIndent(s"You unlock ${o.noun.withDefinite}.")
  }

  def showNoKey() {
    printIndent("You don't have the key to open this.")
  }

  def showCantUnlockBars() {
    printIndent("There's no way to get past the bars.")
  }

  def showAlreadyUnlocked(o: ConcreteArgument with Openable) = {
    printIndent(s"${o.noun.withDefinite.toString.capitalize} isn't locked.")
  }

  def showNoUnlockable() = {
    printIndent(s"There's nothing here to unlock.")
  }

  def showAmbiguousUnlock(openables: Seq[ConcreteArgument with Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite.toString
    val listOr = ListStrings.listOr(stringList)
    printIndent(s"You could unlock $listOr.")
  }

  def showPull() = {
    printIndent(s"You pull the lever.")
  }

  def showNoLever() = {
    printIndent(s"There's nothing here to pull.")
  }

  def showAmbiguousPull(levers: Seq[Lever]) = {
    val stringList: Seq[String] = for (x <- levers) yield x.noun.withDefinite.toString
    val listOr = ListStrings.listOr(stringList)
    printIndent(s"You could unlock $listOr.")
  }

  def showBlockRewind() {
    printIndent("You can't rewind any further.")
  }

  def showRewind() {
    printIndent("SNAP!")
  }
}