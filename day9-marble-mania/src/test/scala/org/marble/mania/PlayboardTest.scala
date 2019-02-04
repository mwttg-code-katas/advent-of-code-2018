package org.marble.mania
import org.scalatest.{ Matchers, WordSpec }

class PlayboardTest extends WordSpec with Matchers {

  "PlayboardTest" should {
    "clockwise insert 2" in {
      val marbles = List(0, 1)
      val subject = new Playboard(marbles, 1)
      val actual  = subject.clockwise(2)
      actual shouldBe List(0, 2, 1)
    }
    "clockwise insert 3" in {
      val marbles = List(0, 2, 1)
      val subject = new Playboard(marbles, 2)
      val actual  = subject.clockwise(3)
      actual shouldBe List(0, 2, 1, 3)
    }
    "clockwise insert 4" in {
      val marbles = List(0, 2, 1, 3)
      val subject = new Playboard(marbles, 3)
      val actual  = subject.clockwise(4)
      println(actual)
    }
  }
}
