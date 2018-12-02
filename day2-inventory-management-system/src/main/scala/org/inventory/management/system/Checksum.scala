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
}
