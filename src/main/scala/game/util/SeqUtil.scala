package game.util

object SeqUtil {
  def containsNoDuplicates(s: List[Any]): Boolean = {
    s match {
      case head :: Nil => true
      case head :: tail => {
        if (tail.contains(head))
          false
        else
          containsNoDuplicates(s)
      }
    }
  }
}
