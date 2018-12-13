package org.alchemical.reduction
import scala.io.Source
import scala.util.Try

class Reduce {
  def getChemical: String = Try(Source.fromResource("puzzle-input.txt").getLines().toSeq).get.head

  def getData(line: String): Seq[Char] = {
    var result = Seq.empty[Char]
    for (index <- 0 until line.length) {
      result = result :+ line(index)
    }
    result
  }

  def reduce2(line: String): String = {
    val length  = line.length
    val builder = new StringBuilder(line)
    for (index <- 0 until length - 1) {
      val c1 = builder.charAt(index)
      val c2 = builder.charAt(index + 1)

      if (c1.toLower == c2.toLower && ((c1.isLower && c2.isUpper) || (c1.isUpper && c2.isLower))) {
        builder.setCharAt(index, '_')
        builder.setCharAt(index + 1, '_')
      }
    }
    builder.replaceAllLiterally("_", "").mkString
  }

  def reduce(data: Seq[Char]): Seq[Char] = {
    var result = data
    for (index <- 0 until (data.length - 1)) {
      val char1 = data(index)
      val char2 = data(index + 1)

      if (char1.toLower == char2.toLower && ((char1.isLower && char2.isUpper) || (char1.isUpper && char2.isLower))) {
        result = result.drop(index).drop(index + 1)
      }
    }
    result
  }

}
