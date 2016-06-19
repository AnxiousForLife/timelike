package game.syntaxEn

abstract class AdjectivePhrase

class SimpleAdjectivePhrase(adj: Adjective) extends AdjectivePhrase {
  override def toString = adj.toString
}

class ConjoinedAdjectivePhrase(aps: Seq[SimpleAdjectivePhrase]) extends AdjectivePhrase {
  override def toString = aps.mkString(", ")
}