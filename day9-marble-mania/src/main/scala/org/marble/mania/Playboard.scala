package org.marble.mania

final case class Playboard(marbles: List[Int] = List(0, 1), currentMarble: Int = 1, currentPlayer: Int = 2, maxPlayer: Int) {

  private[mania] def insert() = {
    val newMarble = currentMarble + 1
    val player = nextPlayer()
    val size              = marbles.size
    val index             = marbles.indexOf(currentMarble)
    val oneClockwiseIndex = oneClockwise(index, size)
    // val twoClockwiseIndex = twoClockwise(index, size)

    if (oneClockwiseIndex == size - 1) {
      val marbleResult = marbles :+ newMarble
      Playboard(marbleResult, newMarble, player, maxPlayer)
    } else {
      val split = marbles.splitAt(oneClockwiseIndex + 1)
      val marbleResult = (split._1 :+ newMarble) ++ split._2
      Playboard(marbleResult, newMarble, player, maxPlayer)
    }

  }

  private def nextPlayer() =
    if (currentPlayer == maxPlayer) {
      1
    } else {
      currentPlayer + 1
    }

  private def oneClockwise(index: Int, size: Int) = {
    val newIndex = index + 1
    correctIndex(newIndex)
  }

  private def twoClockwise(index: Int, size: Int) = {
    val newIndex = index + 2
    correctIndex(newIndex)
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
