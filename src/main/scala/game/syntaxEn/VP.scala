package game.syntaxEn

class VP(xBar: VBar) extends XP[Verb](None, xBar) {
  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String = xBar.inflect(p, n, a)
}

trait VBar extends XBar[Verb] {
  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String
}
class VBarMedialAdvP(adjunct: AdvP, xBar: VBar) extends XBarMedial[Verb](adjunct, xBar) with VBar {
  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String = xBar.inflect(p, n, a)
}
class VBarMedialPP(adjunct: PP, xBar: VBar) extends XBarMedial[Verb](adjunct, xBar) with VBar {
  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String = xBar.inflect(p, n, a)
}

class VBarFinal(head: Verb, compliment: Option[DP]) extends XBarFinal[Verb](head, compliment) {
  def inflect(p: GrammaticalPerson, n: GrammaticalNumber, a: Inflection): String = head.inflect(p, n, a) ++ " " ++ compliment.map(_.toString).getOrElse("")
}
