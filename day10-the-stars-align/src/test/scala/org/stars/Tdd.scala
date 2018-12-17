package org.stars

import org.scalatest.{ Matchers, WordSpec }

class Tdd extends WordSpec with Matchers {
  "TDD" must {
    "resolve some tests" should {
      "create star from content line" in {
        val input  = "position=<-52095,  21032> velocity=< 5, -2>"
        val actual = new SolvePuzzle().createStarFrom(input)
        actual shouldBe Star(Position(-52095, 21032), Velocity(5, -2))
      }
      "move a star" in {
        val subject = Star(Position(-5, 5), Velocity(1, -2))
        val actual  = subject.next()
        actual shouldBe Star(Position(-4, 3), Velocity(1, -2))
      }
    }
  }
}
