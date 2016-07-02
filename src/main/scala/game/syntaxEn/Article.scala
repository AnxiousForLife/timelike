package game.syntaxEn

class Article(override val lemma: String, override val person: GrammaticalPerson, override val number: GrammaticalNumber, override val definiteness: Definiteness)
  extends Determiner(lemma, person, number, definiteness) //The Article Strings are located in DBarFinal.toString

object Article {
  object A extends Article("a", ThirdPerson, Singular, Indefinite)
  object The extends Article("the", ThirdPerson, Singular, Definite)
  object ZeroArticle extends Article("", ThirdPerson, Plural, Indefinite) {
    override def toString = ""
  }
  object ThePlural extends Article("the", ThirdPerson, Plural, Definite)
}
