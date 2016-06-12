package game.syntaxEn

class Adjective(lemma: String) extends Lexeme(lemma) {
  def toAp = new AdjectivePhrase(None, this)
}

object Adjective {
  object BronzeAdj extends Adjective("bronze")
  object IronAdj extends Adjective("iron")
  object MarbleAdj extends Adjective("marble")
  object OpenAdj extends Adjective("open")
  object RustAdj extends Adjective("rusted")
  object WoodenAdj extends Adjective("wooden")
}