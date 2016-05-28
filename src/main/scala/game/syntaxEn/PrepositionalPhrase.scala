package game.syntaxEn

class PrepositionalPhrase(p: Preposition, np: NounPhrase) {
  override def toString = p.toString ++ " " ++ np.toString
}
