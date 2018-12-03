package org.slice.it
import scala.io.Source
import scala.util.Try

class SliceIntersection {
  def getRectangles(filename: String): Seq[Rectangle] = {
    val content = readFile(filename).get
    for (line <- content) yield {
      val numbers = extract(line)
      createRectangleFrom(numbers)
    }
  }

  def readFile(filename: String): Try[Seq[String]] = Try(Source.fromResource(filename).getLines().toSeq)

  def createRectangleFrom(numbers: Array[String]): Rectangle = {
    require(numbers.length == 5, "invalid line format!")
    Rectangle(
      numbers(0).toInt,
      numbers(1).toInt,
      numbers(2).toInt,
      numbers(3).toInt + numbers(1).toInt,
      numbers(4).toInt + numbers(2).toInt
    )
  }

  private def hasContent(input: String): Boolean = if (input.isEmpty) false else true

  def extract(input: String): Array[String] = input.split("(#| |@|,|:|x)").filter(item => hasContent(item))
}
