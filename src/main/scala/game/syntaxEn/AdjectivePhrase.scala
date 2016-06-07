package game.syntaxEn

class AdjectivePhrase(adv: Option[Adverb], adj: Adjective) {
  override def toString = adv.fold("")(x => x.toString ++ " ") ++ adj.toString
}