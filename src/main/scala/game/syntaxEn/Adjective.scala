package game.syntaxEn

class Adjective(lemma: String) extends Lexeme(lemma) {
  def toAp = new SimpleAdjectivePhrase(this)
}

object Adjective {
  object BronzeAdj extends Adjective("bronze")
  object IronAdj extends Adjective("iron")
  object LargeAdj extends Adjective("large")
  object LeadAdj extends Adjective("lead")
  object MarbleAdj extends Adjective("marble")
  object MetalAdj extends Adjective("metal")
  object OpenAdj extends Adjective("open")
  object RustAdj extends Adjective("rusted")
  object SilverAdj extends Adjective("silver")
  object SmallAdj extends Adjective("small")
  object SteelAdj extends Adjective("steel")
  object WoodenAdj extends Adjective("wooden")
}