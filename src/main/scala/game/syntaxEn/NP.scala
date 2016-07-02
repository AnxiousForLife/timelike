package game.syntaxEn

trait AdjunctOfNP
trait ComplementOfNP
//Complement test for NP:
//XP is a complement in an NP iff XP and N cannot be expressed in two separate clauses.
//  "It's a linguistics book with a red cover."
//  "It's a linguistics book, and it has a red cover."
// *"It's a book with a red cover, and it's linguistics."

//  "Linguistics" is the complement of "book," while "with the red cover" is an ADJUNCT.

class NP(xBar: NBar) extends XP[Noun](None, xBar) with AdjunctOfDP with ComplementOfNP {
  override def toString = noSpec

  def decline(number: GrammaticalNumber) = xBar.decline(number)
}

trait NBar extends XBar[Noun] {
  def addAdjunctOption(a: Option[XP[_] with AdjunctOfNP]) = {
    a match {
      case None => this
      case Some(x) => addAdjunct(x)
    }
  }
  def addAdjunct(a: XP[_] with AdjunctOfNP) = {
    a match {
      case ap: AdjP => new NBarAdjP(ap, this)
      case pp: PP => new NBarPP(this, pp)
      case ptcp: PtcP => new NBarPrtP(this, ptcp)
    }
  }

  def addAdjuncts(xps: Seq[XP[_] with AdjunctOfNP]): NP = {
    xps match {
      case x :: Nil => addAdjunct(x).complete
      case x :: xs => addAdjunct(x).addAdjuncts(xs)
    }
  }

  def addAdjunctOptions(xps: Seq[Option[XP[_] with AdjunctOfNP]]): NP = {
    xps match {
      case x :: Nil => addAdjunctOption(x).complete
      case x :: xs => addAdjunctOption(x).addAdjunctOptions(xs)
    }
  }

  def decline(number: GrammaticalNumber): String

  def complete: NP = new NP(this)
}

class NBarAdjP(adjunct: AdjP, xBar: NBar) extends XBarMedial[Noun](adjunct, xBar) with NBar {
  def decline(number: GrammaticalNumber) = {
    //Listing adjectives with commas
    xBar match {
      case _: NBarAdjP => adjunct.toString ++ ", " ++ xBar.decline(number)
      case _ => adjunct.toString ++ xBar.decline(number)
    }
  }
}

class NBarPP(xBar: NBar, adjunct: PP) extends XBarMedial[Noun](adjunct, xBar) with NBar {
  def decline(number: GrammaticalNumber) = xBar.decline(number) ++ adjunct.medialString
}

class NBarPrtP(xBar: NBar, adjunct: PtcP) extends XBarMedial[Noun](adjunct, xBar) with NBar {
  def decline(number: GrammaticalNumber) = xBar.decline(number) ++ adjunct.medialString
}


trait NBarFinal extends NBar {
  def decline(number: GrammaticalNumber): String
}

class NBarFinalSimple(head: Noun) extends XBarFinal[Noun](head, None) with NBarFinal {
  override def toString = head.toString

  def decline(number: GrammaticalNumber) = head.decline(number)
}

class NBarFinalPP(head: Noun, complement: Option[PP]) extends XBarFinal[Noun](head, complement) with NBarFinal {
  override def toString = headFirst

  def decline(number: GrammaticalNumber) = head.decline(number) ++ complement.map(_.medialString).getOrElse("")
}

class NBarFinalCP(head: Noun, complement: Option[CP]) extends XBarFinal[Noun](head, complement) with NBarFinal {
  override def toString = headFirst

  def decline(number: GrammaticalNumber) = head.decline(number) ++ complement.map(_.medialString).getOrElse("")
}

class NBarFinalNP(complement: Option[NP], head: Noun) extends XBarFinal[Noun](head, complement) with NBarFinal {
  override def toString = headSecond

  def decline(number: GrammaticalNumber) = complement.map(_.medialString).getOrElse("") ++ head.decline(number)
}

object NP {
  def quickNP(n: Noun) = new NP(new NBarFinalSimple(n))

  def optionAP(oAdjunct: Option[AdjP], nb: NBar): NBar = {
    oAdjunct match {
      case None => nb
      case Some(adjP) => new NBarAdjP(adjP, nb)
    }
  }

  def optionPP(nb: NBar, oAdjunct: Option[AdjP]): NBar = {
    oAdjunct match {
      case None => nb
      case Some(adjP) => new NBarAdjP(adjP, nb)
    }
  }
}