package game.assets

object Title {
  val str = " _____  ___  __  __  _____      _  ___ __  _  _____ \n|_   _||_ _||  \\/  ||____ |    | ||_ _|\\ \\| ||____ |\n  | |   | | | |\\/| |  |_  |    | | | |  \\ ` |  |_  |\n  | |   | | | |  | | ___| | ___| | | |  / . | ___| |\n  |_|  |___||_|  |_||_____||_____||___|/_/|_||_____|\n"

  def lines: Int = str.split("\n").length
  def width = (str.length - 1) / lines
}
