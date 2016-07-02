package game.syntaxEn

trait Node[T <: SyntacticCategory]

//All subclasses should override `toString`.
abstract class XP[T <: SyntacticCategory](val specifier: Option[XP[_]], xBar: XBar[T]) extends Node[T] {
  def splitWords(str: String) = str.split("  ")
  def condenseWords(str: String) = splitWords(str).map(_.split(" ").mkString("")).mkString(" ")

  def noSpec = xBar.toString
  def specFirst: String = specifier.getOrElse("").toString ++ xBar.toString
  def specSecond: String = xBar.toString ++ specifier.map(_.medialString).getOrElse("")

  def getHead: T = xBar.getHead

  def medialString: String = specFirst
  override def toString = condenseWords(medialString).trim
}

abstract class XBar[T <: SyntacticCategory] extends Node[T] {
  def getHead: T
}

//All subclasses should override `toString`.
abstract class XBarMedial[T <: SyntacticCategory](adjunct: XP[_], xBar: XBar[T]) extends XBar[T] {
  def adjunctFirst: String = adjunct.medialString ++ xBar.toString
  def adjunctSecond: String = xBar.toString ++ adjunct.medialString

  def getHead: T = xBar.getHead
}

//All subclasses should override `toString`.
abstract class XBarFinal[T <: SyntacticCategory](head: T, complement: Option[XP[_]]) extends XBar[T] {
  def headFirst: String = head.toString ++ complement.map(_.medialString).getOrElse("")
  def headSecond: String = complement.map(_.medialString).getOrElse("") ++ head.toString

  def getHead: T = head
}

//abstract class Head[T <: SyntacticCategory](val x: T) extends Node[T]