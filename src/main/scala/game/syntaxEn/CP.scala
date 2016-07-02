package game.syntaxEn

trait ComplementOfCP

class CP(specifier: Option[XP[_]], val xBar: CBar) extends XP[Complementizer](None, xBar)

trait CBar extends XBar[Complementizer]

class CBarCP(head: Complementizer, complement: Option[CP]) extends XBarFinal[Complementizer](head, complement) with CBar {
  override def toString = headFirst
}
class CBarXP(head: Complementizer, complement: Option[XP[_]]) extends XBarFinal[Complementizer](head, complement) with CBar {
  override def toString = headFirst
}