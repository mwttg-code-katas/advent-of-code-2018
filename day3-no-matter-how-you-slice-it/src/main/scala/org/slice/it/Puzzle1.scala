package org.slice.it

object Puzzle1 extends App {
  val filename   = "puzzle-input.txt"
  val intersect  = new SliceIntersection
  val rectangles = intersect.getRectangles(filename)

  var area = 0
  for (x <- 0 until rectangles.length) {
    for (y <- (x + 1) until rectangles.length)
      if (rectangles(x).isIntersecting(rectangles(y))) {
        area = area + rectangles(x).getIntersectionArea(rectangles(y))
      }
  }
  println(area)
}
