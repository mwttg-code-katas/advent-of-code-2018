package org.slice.it

final case class Rectangle(id: Int, top: Int, left: Int, bottom: Int, right: Int) {

  def isIntersecting(anotherRectangle: Rectangle): Boolean =
    !(this.left >= anotherRectangle.right ||
  this.right <= anotherRectangle.left ||
    this.top >= anotherRectangle.bottom ||
    this.bottom <= anotherRectangle.top)

  def getIntersectionArea(that: Rectangle): Int = {
    val these = this.disassemble()
    val those = that.disassemble()
    var area  = 0 // oh no :'( it's mutable
    for (x <- 0 until these.length;
         y <- 0 until those.length) {
      if (these(x).isIntersecting(those(y))) {
        area = area + 1
      }

    }
    area
  }

  def disassemble(): Seq[Rectangle] =
    for (x <- this.left until this.right;
         y <- this.top until this.bottom) yield {
      Rectangle(1, x, y, x + 1, y + 1)
    }
}
