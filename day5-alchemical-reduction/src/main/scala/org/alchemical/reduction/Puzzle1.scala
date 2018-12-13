package org.alchemical.reduction

import scala.io.Source
import scala.util.Try

object Puzzle1 extends App {
  val orgLine = Try(Source.fromResource("puzzle-input.txt").getLines().toSeq).get.head
  val reduce  = new Reduce()

  var line = orgLine
  do {
//for(i <- 1 to 5) {
    println(s"length: ${line.length} -- ${line}")
    val newLine = reduce.reduce2(line)
    // val change = newLine != line
    line = newLine
    // }
  } while (true)
//  val orgData = reduce.getData(orgLine)
//  var line = orgData
//  do {
//    val newLine = reduce.reduce(line)
//    val change = newLine != line
//    println(s" $change -- ${newLine.mkString}")
//    line = newLine
//  } while(true)

}
