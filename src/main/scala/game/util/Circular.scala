package game.util

import scala.collection.mutable.Queue

class Circular[A](list: Seq[A]) extends Iterator[A]{

  val elements = new Queue[A] ++ list
  var pos = 0
  def current = elements(pos)

  def next = {
    val ret = current
    pos += 1
    if (pos == elements.length)
      pos = 0
    ret
  }

  def prev = {
    val ret = current
    pos += 1
    if (pos == 0)
      pos = elements.length
    ret
  }

  def hasNext = !elements.isEmpty

  override def toString = elements.toString

}
