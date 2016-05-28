package game.syntaxEn

//Class for displaying and conjugating noun phrases
class Noun(lemma: String) extends Lexeme(lemma) {
  def toNp = new NounPhrase(None, None, this, None)
  def withDefinite = new NounPhrase(Some(The), None, this, None)
}

abstract class CountableNoun(lemma: String) extends Noun(lemma) {
  val indefinite: Determiner

  def plural = lemma ++ "s"

  def withIndefinite = {
    new NounPhrase(Some(indefinite), None, this, None)
  }
}