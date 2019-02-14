package org.marble.mania

final case class Playboard(board: List[Int] = List(0, 1),
                             marbleStatus: Marbles,
                             playersStatus: Players,
                             winningCondition: WinningCondition) {

  private[mania] def insert() = {
    val size                = board.size
    val currentMarbleNumber = marbleStatus.currentMarbleNumber

    // val twoClockwiseIndex = twoClockwise(index, size)

    if (multipleOfTwentyThree(currentMarbleNumber)) {
      insertMultipleOfTwentyThree(size, currentMarbleNumber)
    } else {
      insertRegular(size)
    }
  }

  private def insertMultipleOfTwentyThree(size: Int, currentMarbleNumber: Int) = {
    val newMarbleIndex = sevenCounterClockwise(marbleStatus.lastIndex, size)
    val (front, back) = board.splitAt(newMarbleIndex)
    val marbleResult = front ++ back.tail

    println(s"marbleIndex = $newMarbleIndex")
    val removedMarble = back.head
    val newPlayerStatus = registerPoints(playersStatus, currentMarbleNumber, removedMarble)

    val newMarbleStatus = marbleStatus.next(newMarbleIndex)
    Playboard(
    marbleResult,
    newMarbleStatus,
    newPlayerStatus,
    winningCondition
  )
  }

  private def registerPoints(players: Players, currentMarble: Int, removedMarble: Int) = {
    val newPoints = currentMarble + removedMarble
    println(s"     -- Points in this turn was: currentMarble=$currentMarble removedMarble=$removedMarble")
    val newPlayers = players.addPoints(newPoints)
    newPlayers.printScore(currentMarble)
    if (newPlayers.highScore() == winningCondition.lastMarbleIsWorth) {
    System.exit(0) // Well, not the nice way
    }
    newPlayers.nextPlayer()
  }

  private def insertRegular(size: Int) = {
    val currentIndex        = marbleStatus.lastIndex
    val currentMarbleNumber = marbleStatus.currentMarbleNumber
    val oneClockwiseIndex   = oneClockwise(currentIndex, size)

    if (oneClockwiseIndex == size - 1) {
      val marbleResult    = board :+ currentMarbleNumber
      val newMarbleStatus = marbleStatus.next(oneClockwiseIndex + 1)
      val newPlayerStatus = playersStatus.nextPlayer()

      Playboard(
        marbleResult,
        newMarbleStatus,
        newPlayerStatus,
        winningCondition
      )
    } else {
      val split = board.splitAt(oneClockwiseIndex + 1)
      val marbleResult    = (split._1 :+ currentMarbleNumber) ++ split._2
      val newMarbleStatus = marbleStatus.next(oneClockwiseIndex + 1)
      val newPlayerStatus = playersStatus.nextPlayer()

      Playboard(
        marbleResult,
        newMarbleStatus,
        newPlayerStatus,
        winningCondition
      )
    }
  }

  private def multipleOfTwentyThree(marble: Int) =
    marble % 23 == 0

  private def sevenCounterClockwise(index: Int, size: Int) = {
    val newIndex = index - 7
    correctIndexCounterClockwwise(newIndex, size)
  }

  private def oneClockwise(index: Int, size: Int) = {
    val newIndex = index + 1
    correctIndexClockwise(newIndex, size)
  }

  private def twoClockwise(index: Int, size: Int) = {
    val newIndex = index + 2
    correctIndexClockwise(newIndex, size)
  }

  private def correctIndexCounterClockwwise(index: Int, size: Int) =
    if (index < 0) {
      size + index // size + (- index)
    } else {
      index
    }

  private def correctIndexClockwise(index: Int, size: Int) =
    if (index >= size) {
      index - size
    } else {
      index
    }
}
