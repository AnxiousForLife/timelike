package game.syntaxEn

abstract class Verb(lemma: String) extends Lexeme(lemma) {
  def inflect(i: Inflection): String
  def toAp = new AdjectivePhrase(new Adjective(lemma))
}

object Verb {
  object Be extends Verb("be") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (FirstPerson, Singular, Present) => "am"
        case (SecondPerson, _, Present) | (_, Plural, Present) => "are"
        case (ThirdPerson, Singular, _) => "is"
        case (SecondPerson, Singular, Past) | (_, Plural, Past) => "were"
        case (_, _, Past) => "was"
      }
    }
  }
  object Hang extends Verb("lie") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (_, _, Past) => "hung"
        case (ThirdPerson, Singular, _) => "hangs"
        case (_, _, _) => "hang"
      }
    }
  }
  object Lie extends Verb("lie") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (_, _, Past) => "lay" //I lay You lay She lay
        case (ThirdPerson, Singular, _) => "lies" //She lies
        case (_, _, _) => "lie" //I lie You lie
      }
    }
  }
  object Pull extends Verb("pull") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (_, _, Past) => "pulled"
        case (ThirdPerson, Singular, _) => "pulls"
        case (_, _, _) => "pull"
      }
    }
  }
  object Sit extends Verb("sit") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (_, _, Past) => "sat"
        case (ThirdPerson, Singular, _) => "sits"
        case (_, _, _) => "sit"
      }
    }
  }
  object Stand extends Verb("stand") {
    def inflect(i: Inflection): String = {
      (i.person, i.number, i.tense) match {
        case (_, _, Past) => "stood"
        case (ThirdPerson, Singular, _) => "stands"
        case (_, _, _) => "stand"
      }
    }
  }
}
