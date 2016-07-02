package game

import game.syntaxEn.Adjective._
import game.syntaxEn.Article.The
import game.syntaxEn.Noun.ImageNoun
import game.syntaxEn.Preposition.{Of, On, With}
import game.syntaxEn.Pronoun.It
import game.syntaxEn.Verb.{Engrave, Write}
import game.syntaxEn._

import scala.util.Try

sealed abstract class ObjectAttribute {
  def xp: XP[_] with AdjunctOfNP
}

class RelativeSize(adj: Adjective) extends ObjectAttribute {
  override def xp = adj.newSimpleAdjP
}

object Large extends RelativeSize(LargeAdj)
object Small extends RelativeSize(SmallAdj)

class Material(adj: Adjective) extends ObjectAttribute {
  override def xp = adj.newSimpleAdjP
}

object Brass extends Material(BrassAdj)
object Cloth extends Material(ClothAdj)
object Iron extends Material(IronAdj)
object Lead extends Material(LeadAdj)
object Marble extends Material(MarbleAdj)
object Metal extends Material(MetalAdj)
object Parchment extends Material(ParchmentAdj)
object Silver extends Material(SilverAdj)
object Stone extends Material(StoneAdj)
object Wooden extends Material(WoodenAdj)

class Image(det: Determiner, n: Noun, v: Verb) extends ObjectAttribute {
  val onIt: PP = On.newPPWithPron(It)
  val verbed: PtcP = v.newPrtP(onIt)
  val dp = det.newDP(n.addFirstAdjunctOption(Option(verbed)).complete)

  override def xp = With.newPP(The.newDP(ImageNoun.addComplementOption(Some(Of.newPP(dp))).complete))
}

abstract class Text(str: String, v: Verb) extends ObjectAttribute { //Any text written on an object
  val onIt: PP = On.newPPWithPron(It)
  val verbed: PtcP = v.newPrtP(onIt)

  def text: String = '"' + str + '"'
  def noun: Noun = {
    if (Try(str.toInt).isSuccess) {
      str.length match {
        case 1 => new Noun(s" numeral ")
        case _ => new Noun(s" number ")
      }
    }
    else str.split(" ").length match {
      case 1 => new Noun(s" word ")
      case _ => new Noun(s" words ")
    }
  }

  override def xp = With.newPP(The.newDP(new Noun(text).addComplementOption(Some(noun.newSimpleNP)).addAdjunct(verbed).complete))
}

class Writing(str: String) extends Text(str, Write)
class Engraving(str: String) extends Text(str, Engrave)