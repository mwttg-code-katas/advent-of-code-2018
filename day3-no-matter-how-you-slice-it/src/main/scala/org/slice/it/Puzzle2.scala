package org.slice.it

object Puzzle2 extends App {
  val filename = "puzzle-input.txt"
  val claims = Slicer.getClaimsFrom(filename)

  val result = claims.map(item => Slicer.testClaim(item, claims))
  val id = result.indexWhere(item => item == false)
  println(id + 1)
}
