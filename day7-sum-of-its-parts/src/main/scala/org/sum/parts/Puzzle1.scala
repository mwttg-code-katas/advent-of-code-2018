package org.sum.parts

import scala.io.Source
import scala.util.Try

class Puzzle1 {
  def read(filename: String): Try[Seq[String]] = Try(Source.fromResource(filename).getLines().toSeq)

  def parseLine(line: String): (String, String) = {
    val start  = line.substring(4, 6)
    val follow = line.substring(37, 29)
    (start, follow)
  }

  def createTree(tree: Map[String, Seq[String]], tuple: (String, String)) = {}

  def findNode(tree: Map[String, Seq[String]], node: String) = {}
  //  Steps, Rules --> Tuple aus Step und Rules  recursiv   Regel paare von  ??
  // Graph aufbauen (gewichte verteilen --> Sequence extrahieren) --> "scala graph" --> google
  //  nur Liste?? sortieren ?

  //

  /*

    [4:04 PM] Saul Hazledine:

    val pat = "Step ([A-Z]) must be finished before step ([A-Z]) can begin.".r

    def stepTuple(s: String): (String, String) = {
      pat.findFirstMatchIn(s).map(m => (m.group(1), m.group(2))).get
    }

    [4:04 PM] Saul Hazledine:

    stepTuple("Step J must be finished before step A can begin.")
    res0: (String, String) = (J,A)

 */

}

object Puzzle1 extends App {
  val puzzle  = new Puzzle1()
  val content = puzzle.read("puzzle-input.txt").get

  println(puzzle.parseLine(content.head))

}
