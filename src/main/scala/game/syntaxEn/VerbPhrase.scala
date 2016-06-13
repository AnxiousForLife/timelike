package game.syntaxEn

class VerbPhrase(t: Tense, np: NounPhrase, verb: Verb, pp: PrepositionalPhrase) {
  override def toString = Seq(np.toString, verb.inflect(new Inflection (np.person, np.number, t)), pp.toString).mkString(" ")
  def ppFirst = Seq(pp.toString, verb.inflect(new Inflection (np.person, np.number, t)), np.toString).mkString(" ")
}