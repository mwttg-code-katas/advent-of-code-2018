package org.alchemical.reduction
import scala.io.Source
import scala.util.Try

// I would try to write beautiful code, but i've no time :(
object Puzzle2 extends App {
  val orgLine = Try(Source.fromResource("puzzle-input.txt").getLines().toSeq).get.head
  val reduce  = new Reduce()

  val chars = 'a' to 'z'

  var min = 10000000
  for (letter <- chars) {
    val newLine = reduce.reduceP2(orgLine, letter)
    var x       = true
    var oldL    = 0
    var line    = newLine
    var count   = 0
    do {
      val l = reduce.reduceP22(line)
      println(l.length)
      if (l.length < min) {
        min = l.length
      }

      if (oldL == l.length) {
        count = count + 1
      }

      if (count == 5) {
        x = false
      }

      oldL = l.length
      line = l
    } while (x == true)

  }
  println(s"min=${min}")
}
