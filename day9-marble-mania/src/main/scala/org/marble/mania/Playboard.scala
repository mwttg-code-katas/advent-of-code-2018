package org.marble.mania

final case class Playboard(marbles: List[Int] = List(0, 1), currentMarble: Int = 1, currentPlayer: Int = 2, maxPlayer: Int) {

  private[mania] def insert() = {
    val newMarble = currentMarble + 1
    val player = nextPlayer()
    val size              = marbles.size
    val currentIndex = marbles.indexOf(currentMarble)


    // val twoClockwiseIndex = twoClockwise(index, size)

    if (multipleOfTwentyThree(newMarble)) {
      insertMultipleOfTwentyThree(currentIndex, size, newMarble, player, maxPlayer)
    } else {
      insertRegular(currentIndex, size, newMarble, player)
    }
  }

  private def insertMultipleOfTwentyThree(index: Int, size: Int, newMarble: Int, player: Int, maxPlayer: Int) = {
    val removeIndex           = sevenCounterClockwise(index, size)
    val (front, back)         = marbles.splitAt(removeIndex)
    val newMarbles            = front ++ back.tail
    val newCurrentMarbleIndex = removeIndex
    Playboard(newMarbles, newMarble, player, maxPlayer)
  }

  private def insertRegular(index: Int, size: Int, newMarble: Int, player: Int) = {
    val oneClockwiseIndex = oneClockwise(index, size)
    if (oneClockwiseIndex == size - 1) {
      val marbleResult = marbles :+ newMarble
      Playboard(marbleResult, newMarble, player, maxPlayer)
    } else {
      val split        = marbles.splitAt(oneClockwiseIndex + 1)
      val marbleResult = (split._1 :+ newMarble) ++ split._2
      Playboard(marbleResult, newMarble, player, maxPlayer)
    }
  }

  private def multipleOfTwentyThree(marble: Int) = {
    marble % 23 == 0
  }

  private def nextPlayer() =
    if (currentPlayer == maxPlayer) {
      1
    } else {
      currentPlayer + 1
    }

  private def sevenCounterClockwise(index: Int, size: Int) = {
    val newIndex = index - 7
    correctIndexCounterClockwwise(newIndex , size)
  }

  private def oneClockwise(index: Int, size: Int) = {
    val newIndex = index + 1
    correctIndexClockwise(newIndex, size)
  }

  private def twoClockwise(index: Int, size: Int) = {
    val newIndex = index + 2
    correctIndexClockwise(newIndex, size)
  }

  private def correctIndexCounterClockwwise(index: Int, size: Int) = {
    if (index < 0) {
      size + index // size + (- index)
    } else {
      index
    }
  }

  private def correctIndexClockwise(index: Int, size: Int) = {
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
