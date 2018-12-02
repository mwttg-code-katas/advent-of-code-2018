package org.inventory.management.system
import scala.io.Source
import scala.util.Try

class Checksum {
  def generateCounts(input: String): Array[(Char, Int)] =
    input.distinct.toCharArray.map(item => (item, input.count(letter => letter == item)))

  def twoTimes(tuples: Array[(Char, Int)]): Int = tuples.count(tuple => tuple._2 == 2)

  def threeTimes(tuples: Array[(Char, Int)]): Int = tuples.count(tuple => tuple._2 == 3)

  def scanBoxId(input: String): (Int, Int) = {
    val counts = generateCounts(input)
    val x      = if (twoTimes(counts) > 0) 1 else 0
    val y      = if (threeTimes(counts) > 0) 1 else 0
    (x, y)
  }

  def readFile(filename: String): Try[Seq[String]] = Try(Source.fromResource(filename).getLines().toSeq)

  def processIds(lines: Seq[String]): Seq[(Int, Int)] = lines.map(line => scanBoxId(line))

  def sumUp(tuples: Seq[(Int, Int)]): (Int, Int) = tuples.foldLeft((0, 0)) { case ((accA, accB), (a, b)) => (accA + a, accB + b) }

  def startPuzzle1(filename: String) = {
    val content = readFile(filename).get
    val counts  = processIds(content)
    sumUp(counts)
  }

  // -- Puzzle 2
  // Well  :-S ugly as hell and not FP (no time)
  // I'm really sorry

  def puzzle2(filename: String) = {
    val lines = readFile(filename).get
    for (index <- 0 until 250) {
      val line = lines(index)
      for (toProofIndex <- index + 1 until 250) {
        val proofLine = lines(toProofIndex)
        val result    = proof(line, proofLine)
        if (result.isDefined) {
          println(s"$line -- $proofLine -- ${line diff proofLine}")
        }

        val result2 = proof2(line, proofLine)
        if (result2.length == 1) {
          println(s"** $line -- $proofLine -- ${result2(0)} --> ${line intersect proofLine}")
        }
      }
    }
  }

  def proof(line: String, proofLine: String): Option[(String, String)] = {
    val difference = line diff proofLine
    if (difference.length > 1) return None
    Some((line, proofLine))
  }

  def proof2(line: String, proofLine: String) = {
    var result = Array.emptyCharArray

    for (index <- 0 until line.length) {
      val letter1 = line.charAt(index)
      val letter2 = proofLine.charAt(index)

      if (letter1 != letter2) {
        result = result :+ letter1
      }
    }
    result
  }
}
