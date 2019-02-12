package org.marble.mania
import org.scalatest.{ Matchers, WordSpec }

class PlayboardTest extends WordSpec with Matchers {

  "Playboard Test" should {
    val playerStatus = Players().initialize(9)
    val expectedPlayerStatus = playerStatus.nextPlayer()

    "insert 2" in {
      val marbleStatus = Marbles(2, 1)
      val marbles      = List(0, 1)
      val subject      = Playboard(marbles, marbleStatus, playerStatus)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(3, 1)
      actual shouldBe Playboard(
        List(0, 2, 1),
        expectedMarbleStatus,
        expectedPlayerStatus
      )
    }

    "insert 3" in {
      val marbleStatus = Marbles(3, 1)
      val marbles      = List(0, 2, 1)
      val subject      = Playboard(marbles, marbleStatus, playerStatus)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(4, 3)
      actual shouldBe Playboard(
        List(0, 2, 1, 3),
        expectedMarbleStatus,
        expectedPlayerStatus
      )
    }

    "insert 4" in {
      val marbleStatus = Marbles(4, 3)
      val marbles      = List(0, 2, 1, 3)
      val subject      = Playboard(marbles, marbleStatus, playerStatus)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(5, 1)
      actual shouldBe Playboard(
        List(0, 4, 2, 1, 3),
        expectedMarbleStatus,
        expectedPlayerStatus
      )
    }

    "insert 22" in {
      val marbleStatus = Marbles(22, 11)
      val marbles      = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject      = Playboard(marbles, marbleStatus, playerStatus)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(23, 13)
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        expectedMarbleStatus,
        expectedPlayerStatus
      )
    }

    "insert 23" in {
      val marbleStatus = Marbles(23, 13)
      val marbles = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject = Playboard(marbles, marbleStatus, playerStatus)

      val actual               = subject.insert()
      val expectedMarbleStatus = Marbles(24, 6)
      actual shouldBe Playboard(
    List(0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
    expectedMarbleStatus,
    expectedPlayerStatus
  )
    }

    "insert 24" in {
      val marbleStatus = Marbles(24, 6)
      val marbles = List(0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject = Playboard(marbles, marbleStatus, playerStatus)

      val actual = subject.insert()
      val expectedMarbleStatus = Marbles(25, 8)
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 19, 2, 24, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        expectedMarbleStatus,
        expectedPlayerStatus
      )
    }
//
//    "ttt" in {
//      val marbles = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
//      val subject = Playboard(marbles, 22, 4, 9)
//      val actual  = subject.insert()
//      println(actual)
//    }
  }
}
