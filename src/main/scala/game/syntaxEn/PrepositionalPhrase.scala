package game.syntaxEn

class PrepositionalPhrase(p: Preposition, np: SingularNounPhrase) {
  override def toString = p.toString ++ " " ++ np.toString
}
