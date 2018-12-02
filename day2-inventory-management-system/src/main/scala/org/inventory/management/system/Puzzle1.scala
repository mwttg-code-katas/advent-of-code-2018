package org.inventory.management.system

object Puzzle1 extends App {
  val filename = "checksum-list.txt"
  val checksum = new Checksum
  val sum      = checksum.startPuzzle1(filename)
  println(s"The checksum is $sum and this makes ${sum._1 * sum._2}")
}
