package org.marble.mania

class Playboard(marbles: List[Int], currentMarble: Int) {

  // def insert(marble: Int): Playboard = {}

  private[mania] def clockwise(marble: Int) = {
    val size              = marbles.size
    val index             = marbles.indexOf(currentMarble)
    val oneClockwiseIndex = oneClockwise(index, size)
    val twoClockwiseIndex = twoClockwise(index, size)

    if (oneClockwiseIndex == size - 1) {
      marbles :+ marble
    } else {
      val split = marbles.splitAt(oneClockwiseIndex + 1)
      (split._1 :+ marble) ++ split._2
    }

  }

  private def oneClockwise(index: Int, size: Int) = {
    val result = index + 1
    if (result >= size) {
      result - size
    } else {
      result
    }
  }

  private def twoClockwise(index: Int, size: Int) = {
    val result = index + 2
    if (result >= size) {
      result - size
    } else {
      result
    }
  }

  private def correctIndex(index: Int) = {
    val size = marbles.size
    if (index >= size) {
      index - size
    } else {
      index
    }
  }
}
/**
  *
  *            1111
  *  01234567890123
  *
  *
  *  index 13 size 14
  *
  *
  */
