package game.syntaxEn

//import game.util.NumberToWords

sealed trait Definiteness

object Definite extends Definiteness

object Indefinite extends Definiteness

class Determiner(str: String, val person: GrammaticalPerson, val number: GrammaticalNumber, val definiteness: Definiteness)
  extends Lexeme(str) with SyntacticCategory {

  def newDP(np: NP) = new DP(None, new DBarFinal(this, Some(np)))
  def quickDP(n: Noun) = new DP(None, new DBarFinal(this, Some(n.newSimpleNP)))
}

object Determiner {
  class PossessiveParticle(override val person: GrammaticalPerson,
                           override val number: GrammaticalNumber,
                           override val definiteness: Definiteness) extends Determiner("'s", person, number, definiteness) {
    override def toString = lemma ++ " "
  }


  //def number(n: Int) = new Determiner(NumberToWords.convert6(n))
}