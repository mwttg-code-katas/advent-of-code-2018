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


  // This doesn't work, perhaps a better idea wold be to
  // * create a giant data structure (2d- array) with 0
  // * Take a claim
  // * check the space for the claim
  // * if it is 0 put in the claim and store a 1 into the array
  // * if it is 1 put in the claim and store a x into the array
  // count the x

}
