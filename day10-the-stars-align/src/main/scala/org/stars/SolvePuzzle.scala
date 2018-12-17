package org.stars
import org.common.FileReader

class SolvePuzzle {
  def createStarFrom(line: String): Star = {
    val x        = line.substring(10, 16).filterNot(char => char.isWhitespace).toInt
    val y        = line.substring(18, 24).filterNot(char => char.isWhitespace).toInt
    val deltaX   = line.substring(36, 38).filterNot(char => char.isWhitespace).toInt
    val deltaY   = line.substring(40, 42).filterNot(char => char.isWhitespace).toInt
    val position = Position(x, y)
    val velocity = Velocity(deltaX, deltaY)
    Star(position, velocity)
  }

  def createStars(filename: String): Seq[Star] = {
    val lines = FileReader.read(filename).get
    lines.map(line => createStarFrom(line))
  }

  def next(stars: Seq[Star]): Seq[Star] =
    stars.map(star => star.next())
}
