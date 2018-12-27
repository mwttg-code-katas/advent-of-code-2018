package org.slice.it
import scala.collection.immutable.IndexedSeq

final case class Claim(id: Int, left: Int, top: Int, width: Int, height: Int) {
  val points: IndexedSeq[(Int, Int)] = getPoints

  def getLeftTop: (Int, Int) =
    (left, top)

  def getRightBottom: (Int, Int) =
    (left + width - 1, top + height - 1)

  private def getPoints: IndexedSeq[(Int, Int)] =
    for (x <- 0 until width;
         y <- 0 until height) yield {
      (x + left, y + top)
    }

  def doesIntersectWith(other: Claim): Boolean = {
    val result = points.map(item => other.points.contains(item))
    result.find(item => item == true).getOrElse(false)
  }
}

object Claim {
  def createFrom(input: String): Claim = {
    val parts = input.split("(#| |@|,|:|x)").filter(item => !item.isEmpty)
    Claim(
      parts(0).toInt,
      parts(1).toInt,
      parts(2).toInt,
      parts(3).toInt,
      parts(4).toInt
    )
  }
}
