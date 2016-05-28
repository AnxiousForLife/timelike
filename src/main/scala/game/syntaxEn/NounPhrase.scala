package game.syntaxEn

class NounPhrase(det: Option[Determiner], ap: Option[AdjectivePhrase], n: Noun, pp: Option[PrepositionalPhrase]) {
  override def toString =
    det.fold("")(x => x.toString ++ " ") ++ ap.fold("")(x => x.toString ++ " ") ++ n.toString ++ pp.fold("")(x => " " ++ x.toString)
}
