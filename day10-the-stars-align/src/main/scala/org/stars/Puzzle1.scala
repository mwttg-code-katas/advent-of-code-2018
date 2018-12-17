package org.stars
import java.awt.Color

object Puzzle1 extends App {
  val filename = "puzzle-input.txt"
  val puzzle   = new SolvePuzzle()

  var stars = puzzle.createStars(filename)

  val image = new RgbBitmap(10000, 10000)

  var index = 0
  do {
    //image.fill(Color.BLACK)
    val imageFilename = s"drawing$index.png"
    val newStars      = stars.map(star => star.next())
    if (index > 6000) {
      newStars.foreach(item => {
        if ((item.position.x > 0 && item.position.x < 10000) && (item.position.y > 0 && item.position.y < 10000))
          image.update(item.position.x, item.position.y, Color.YELLOW)
      })

      image.saveImage(imageFilename)
    }
    index = index + 1
    println(imageFilename)

  } while (true)

}
