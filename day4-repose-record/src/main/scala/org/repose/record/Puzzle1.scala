package org.repose.record

object Puzzle1 extends App {
  val input = GetInput("test-input.txt")
  input.foreach(item => println(s"date[${item._1}] -- content [${item._2}]"))

  for (item <- input) {}
}
