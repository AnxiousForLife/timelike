package game.syntaxEn

class Adjective(lemma: String) extends Lexeme(lemma) {
  def toAp = new AdjectivePhrase(None, this)
}

object Adjective {
  object IronAdj extends Adjective("iron")
  object OpenAdj extends Adjective("open")
  object WoodenAdj extends Adjective("wooden")
}