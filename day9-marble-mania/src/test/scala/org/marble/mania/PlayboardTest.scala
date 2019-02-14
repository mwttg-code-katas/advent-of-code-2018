package org.marble.mania
import org.scalatest.{ Matchers, WordSpec }

class PlayboardTest extends WordSpec with Matchers {

  "Playboard Test" should {
    val playerStatus = Players().initialize(9)
    val winningCondition = WinningCondition(1000)
    val expectedPlayerStatus = playerStatus.nextPlayer()

    "insert 2" in {
      val marbleStatus = Marbles(2, 1)
      val marbles = List(0, 1)
      val subject      = Playboard(marbles, marbleStatus, playerStatus, winningCondition)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(3, 1)
      actual shouldBe Playboard(
        List(0, 2, 1),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )
    }

    "insert 3" in {
      val marbleStatus = Marbles(3, 1)
      val marbles      = List(0, 2, 1)
      val subject      = Playboard(marbles, marbleStatus, playerStatus, winningCondition)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(4, 3)
      actual shouldBe Playboard(
        List(0, 2, 1, 3),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )
    }

    "insert 4" in {
      val marbleStatus = Marbles(4, 3)
      val marbles      = List(0, 2, 1, 3)
      val subject      = Playboard(marbles, marbleStatus, playerStatus, winningCondition)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(5, 1)
      actual shouldBe Playboard(
        List(0, 4, 2, 1, 3),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )
    }

    "insert 22" in {
      val marbleStatus = Marbles(22, 11)
      val marbles      = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject      = Playboard(marbles, marbleStatus, playerStatus, winningCondition)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(23, 13)
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )
    }

    "insert 23" in {
      val marbleStatus = Marbles(23, 13)
      val marbles      = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject = Playboard(marbles, marbleStatus, playerStatus, winningCondition
      )

      val actual = subject.insert()
      val expectedMarbleStatus = Marbles(24, 6)
      val expectedPlayerStatus = Players(
    Map(5 -> 0, 1 -> 32, 6 -> 0, 9 -> 0, 2 -> 0, 7 -> 0, 3 -> 0, 8 -> 0, 4 -> 0),
    2
  )
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )
    }

    "insert 24" in {
      val marbleStatus = Marbles(24, 6)
      val marbles      = List(0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject      = Playboard(marbles, marbleStatus, playerStatus, winningCondition)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(25, 8)
      actual shouldBe Playboard(
    List(0, 16, 8, 17, 4, 18, 19, 2, 24, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
    expectedMarbleStatus,
    expectedPlayerStatus,
    winningCondition
  )
    }

    "whole process insert 2 .. 25" in {
      val marbleStatus = Marbles(2, 1)
      val playerStatus = Players(
    Map(5 -> 0, 1 -> 0, 6 -> 0, 9 -> 0, 2 -> 0, 7 -> 0, 3 -> 0, 8 -> 0, 4 -> 0),
    2
  )
      val marbles = List(0, 1)

      // var :(  -> recursive?
  var subject = Playboard(
    marbles,
    marbleStatus,
    playerStatus,
    winningCondition
  )
      for (iteration <- 2 to 24) {
    subject = subject.insert()
  }
      val actual = subject.insert() // last move insert 25

      val expectedMarbleStatus = Marbles(26, 10)
      val expectedPlayerStatus = Players(
        Map(5 -> 32, 1 -> 0, 6 -> 0, 9 -> 0, 2 -> 0, 7 -> 0, 3 -> 0, 8 -> 0, 4 -> 0), 8)
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 19, 2, 24, 20, 25, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        expectedMarbleStatus,
        expectedPlayerStatus,
        winningCondition
      )

    }
  }
}
