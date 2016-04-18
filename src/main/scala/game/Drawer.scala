package game

class Drawer(var item: Option[Item]) {
  def show() = {
    item match {
      case None => "There's nothing inside."
      case Some(x) => s"There's ${x.withArticle} inside."
    }
  }
}

object Drawer extends Noun("drawer", "a", None)