package game.syntaxEn

sealed class Pronoun(lemma: String) extends Noun(lemma)

object Pronoun {
  object I extends Pronoun("I")
  object It extends Pronoun("it")
}