package game.syntaxEn

class Adverb(lemma: String) extends Lexeme(lemma) with SyntacticCategory {
  def newSimpleAdvP = new AdvP(new AdvBarFinal(this))
}
