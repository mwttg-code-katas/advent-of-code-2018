package org.marble.mania
import org.scalatest.{ Matchers, WordSpec }

class PlayboardTest extends WordSpec with Matchers {

  "PlayboardTest" should {
    "insert 2" in {
      val marbles = List(0, 1)
      val subject = Playboard(maxPlayer = 9)
      val actual = subject.insert()
      actual shouldBe Playboard(List(0, 2, 1), 2, 3, 9)
    }
    "insert 3" in {
      val marbles = List(0, 2, 1)
      val subject = Playboard(marbles, 2, 3, 9)
      val actual  = subject.insert()
      actual shouldBe Playboard(List(0, 2, 1, 3), 3, 4, 9)
    }
    "insert 4" in {
      val marbles = List(0, 2, 1, 3)
      val subject = Playboard(marbles, 3, 4, 9)
      val actual  = subject.insert()
      actual shouldBe Playboard(List(0, 4, 2, 1, 3), 4, 5, 9)
    }
    "insert 22" in {
      val marbles = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject = Playboard(marbles, 21, 3, 9)
      val actual = subject.insert()
      actual shouldBe Playboard(
        List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15),
        22,
        4,
        9
      )
      println(actual)
    }
    "insert 23" in {
    val marbles = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
    val subject = Playboard(marbles, 22, 4, 9)
  }

    "ttt" in {
      val marbles = List(0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
      val subject = Playboard(marbles, 22, 4, 9)
      val actual  = subject.insert()
      println(actual)
    }
  }
}
