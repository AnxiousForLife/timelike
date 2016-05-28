package game.engine

import game.{Argument, _}
import game.assets.Items.Compass
import game.assets.Title
import game.util.ListStrings

object Output {
  def showTitle() = println(Title.str)

  def showReturnTitle() = {
    val returnText = "[PRESS ENTER (↵)]"
    val spacesAmt = Title.width - returnText.length
    println(" " * spacesAmt ++ "[PRESS ENTER (↵)]")
  }
  def showReturnShort() = println("(↵)")

  def showInvalid() = println("That means nothing here.")

  def showFOV(state: GameState) = {
    val directionText: String = {
      if (Inventory.contains(Compass)) s"You're facing ${state.direction}."
      else ""
    }
    val doorText: String = {
      state.currentWall.door match {
        case None => ""
        case Some(door: Door) => {
          if (door.isOpen) " There's an open door."
          else " There's " ++ door.noun.withIndefinite(door.adj1, door.adj2) ++ "."
        }
      }
    }

    val argumentText: String = {
      (for (x <- state.currentWall.arguments) yield (" There's " ++ x.noun.withIndefinite(None, None) ++ ".")).mkString(" ")
    }

    val itemsText: String = {
      state.currentWall.availItems match {
        case Nil => ""
        case items => {
          val stringList: Seq[String] = for (x <- items) yield x.noun.withIndefinite(None, None)
          " There's " ++ ListStrings.listOr(stringList) ++ " here."
        }
      }
    }
    println((directionText ++ doorText ++ argumentText ++ itemsText).capitalize)
  }

  def showAmbiguousDirection() = {
    println("But which way?")
  }

  def showNotADirection(a: Argument) = {
    println(s""""$a" is not a direction.""")
  }

  def showTurn(rd: RelativeDirection) = {
    println(s"You turn $rd.")
  }

  def showOpen(o: Openable) = {
    println(s"You open ${o.noun.withDefinite}.")
  }

  def showAlreadyOpened(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} is already open.")
  }

  def showCantOpen() = {
    println("You can't open that.")
  }

  def showNoOpenable() = {
    println(s"There's nothing here to open.")
  }

  //Prints a list of things the player can open if they don't specify what to open.
  def showAmbiguousOpen(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You could open $listOr.")
  }

  def showClose(o: Openable) = {
    println(s"You close ${o.noun.withDefinite}.")
  }

  def showAlreadyClosed(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} is already closed.")
  }

  def showCantClose() = {
    println("You can't open that.")
  }

  def showNoCloseable() = {
    println(s"There's nothing here to close.")
  }

  def showAmbiguousClose(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"Could close $listOr.")
  }

  def showNoExit() {
    println("There's exit here.")
  }

  def showEnterRoom() {
    println("You walk through the doorway.")
  }

  def showDoorClosed() {
    println("The door is closed.")
  }

  def showCantEnter() {
    println("You can't enter that.")
  }

  def showNoItem() {
    println("There's nothing here to take.")
  }

  //Prints a list of items the player can take if they don't specify what to take.
  def showAmbiguousTake(items: Seq[Item]) = {
    val stringList: Seq[String] = for (x <- items) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You could take $listOr.")
  }

  def showTakeItem(x: Item) {
    println(s"You take the $x.")
  }

  def showUnavailableArgument() {
    println(s"There's nothing like that here.")
  }

  def showCantTake() {
    println(s"You can't take that.")
  }

  def showCantUnlock() {
    println("You can't unlock that.")
  }

  def showKeyLocked() {
    println("The door is locked.")
  }

  def showDoorBarred() {
    println("The door is blocked by bars.")
  }

  def showUnlock(o: Openable) {
    println(s"You unlock ${o.noun.withDefinite}.")
  }

  def showNoKey() {
    println("You don't have the key to open this.")
  }

  def showCantUnlockBars() {
    println("There's no way to get past the bars.")
  }

  def showAlreadyUnlocked(o: Openable) = {
    println(s"${o.noun.withDefinite.capitalize} isn't locked.")
  }

  def showNoUnlockable() = {
    println(s"There's nothing here to unlock.")
  }

  def showAmbiguousUnlock(openables: Seq[Openable]) = {
    val stringList: Seq[String] = for (x <- openables) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You could unlock $listOr.")
  }

  def showPull() = {
    println(s"You pull the lever.")
  }

  def showNoLever() = {
    println(s"There's nothing here to pull.")
  }

  def showAmbiguousPull(levers: Seq[Lever]) = {
    val stringList: Seq[String] = for (x <- levers) yield x.noun.withDefinite
    val listOr = ListStrings.listOr(stringList)
    println(s"You could unlock $listOr.")
  }

  def showBlockRewind() {
    println("You can't rewind any further.")
  }

  def showRewind() {
    println("SNAP!")
  }
}