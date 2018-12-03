package org.slice.it

final case class Rectangle(id: Int, top: Int, left: Int, bottom: Int, right: Int) {

  def isIntersecting(anotherRectangle: Rectangle): Boolean =
    !(this.left > anotherRectangle.right ||
    this.right < anotherRectangle.left ||
    this.top > anotherRectangle.bottom ||
    this.bottom < anotherRectangle.top)

  def getIntersectionArea(that: Rectangle): Int = {
    val left          = Math.max(this.left, that.left)
    val right         = Math.min(this.right, that.right)
    val bottom        = Math.max(this.bottom, that.bottom)
    val top           = Math.min(this.top, that.top)
    val area1         = (this.bottom - this.top) * (this.right - this.left)
    val area2         = (that.bottom - that.top) * (that.right - that.left)
    val intersectArea = Math.abs(right - left) * Math.abs(bottom - top)
    intersectArea
  }
}
