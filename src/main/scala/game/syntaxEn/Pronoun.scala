package game.syntaxEn

sealed abstract class Pronoun(lemma: String,
                              override val person: GrammaticalPerson,
                              override val number: GrammaticalNumber,
                              override val definiteness: Definiteness)
  extends Determiner(lemma, person, number, definiteness) {
  val _accusative: String
  val _dependentPossessive: String
  val _independentPossessive: String
  val _reflexive: String = {
    number match {
      case Singular => _dependentPossessive + "self"
      case Plural => _dependentPossessive + "selves"
    }
  }
  val accusative = new Determiner(_accusative, person, number, definiteness)
  val dependentPossessive = new Determiner(_dependentPossessive, person, number, definiteness)
  val independentPossessive = new Determiner(_independentPossessive, person, number, definiteness)
  val reflexive = new Determiner(_reflexive, person, number, definiteness)

  def dp = new DP(None, new DBarFinal(this, None))
}

object Pronoun {
  object He extends Pronoun("he", ThirdPerson, Singular, Definite) {
    override val _accusative = "him"
    override val _dependentPossessive = "his"
    override val _independentPossessive = _dependentPossessive
  }
  object I extends Pronoun("I", FirstPerson, Singular, Definite) {
    override val _accusative = "me"
    override val _dependentPossessive = "my"
    override val _independentPossessive = "mine"
  }
  object It extends Pronoun("it", ThirdPerson, Singular, Definite) {
    override val _accusative = lemma
    override val _dependentPossessive = "its"
    override val _independentPossessive = _dependentPossessive
  }
  object One extends Pronoun("one", ThirdPerson, Singular, Indefinite) {
    override val _accusative = "one"
    override val _dependentPossessive = "one's"
    override val _independentPossessive = _dependentPossessive
  }
  object She extends Pronoun("she", ThirdPerson, Singular, Definite) {
    override val _accusative = "her"
    override val _dependentPossessive = "her"
    override val _independentPossessive = "hers"
  }
  object They extends Pronoun("they", ThirdPerson, Plural, Definite) {
    override val _accusative = "them"
    override val _dependentPossessive = "their"
    override val _independentPossessive = "theirs"
  }
  object We extends Pronoun("we", FirstPerson, Plural, Definite) {
    override val _accusative = "us"
    override val _dependentPossessive = "our"
    override val _independentPossessive = "ours"
  }
  object You extends Pronoun("you", SecondPerson, Singular, Definite) {
    override val _accusative = "you"
    override val _dependentPossessive = "your"
    override val _independentPossessive = "yours"
  }
  object YouPlural extends Pronoun("you", SecondPerson, Plural, Definite) {
    override val _accusative = You._accusative
    override val _dependentPossessive = You._dependentPossessive
    override val _independentPossessive = You._independentPossessive
  }
  object Who extends Pronoun("who", ThirdPerson, Singular, Definite) {
    override val _accusative = "who"
    override val _dependentPossessive = "whose"
    override val _independentPossessive = _dependentPossessive
    override val _reflexive = They._reflexive // :O
  }
}