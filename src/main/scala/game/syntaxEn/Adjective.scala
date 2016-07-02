package game.syntaxEn

class Adjective(lemma: String) extends Lexeme(lemma) with SyntacticCategory {
  def newAdjBar(pp: Option[PP]) = new AdjBarFinal(this, pp)
  def newSimpleAdjBar = newAdjBar(None)
  def newSimpleAdjP = new AdjP(None, newSimpleAdjBar)
}

object Adjective {
  object BrassAdj extends Adjective("brass")
  object BronzeAdj extends Adjective("bronze")
  object ClothAdj extends Adjective("cloth")
  object IronAdj extends Adjective("iron")
  object LargeAdj extends Adjective("large")
  object LeadAdj extends Adjective("lead")
  object MarbleAdj extends Adjective("marble")
  object MetalAdj extends Adjective("metal")
  object OpenAdj extends Adjective("open")
  object ParchmentAdj extends Adjective("parchment")
  object RustAdj extends Adjective("rusted")
  object SilverAdj extends Adjective("silver")
  object SmallAdj extends Adjective("small")
  object SteelAdj extends Adjective("steel")
  object StoneAdj extends Adjective("stone")
  object WoodenAdj extends Adjective("wooden")
}