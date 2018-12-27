package org.slice.it
import org.scalatest.{ Matchers, WordSpec }

class ClaimTest extends WordSpec with Matchers {
  "Claim" must {
    "read text input" should {
      "create a claim" in {
        val input    = "#2 @ 75,649: 23x11"
        val actual   = Claim.createFrom(input)
        val expected = Claim(2, 75, 649, 23, 11)
        actual shouldBe expected
      }
    }
    "provide coordinates" should {
      "return leftTop" in {
        val subject = Claim(1, 1, 3, 4, 4)
        val actual  = subject.getLeftTop
        actual shouldBe (1, 3)
      }
      "return rightBottom" in {
        val subject = Claim(1, 1, 3, 4, 4)
        val actual  = subject.getRightBottom
        actual shouldBe (4, 6)
      }
    }
    "provide point-list" should {
      "return points" in {
        val subject = Claim(1, 1, 3, 4, 4)
        val actual  = subject.points
        actual should contain theSameElementsAs Seq(
          (1, 3),
          (1, 4),
          (1, 5),
          (1, 6),
          (2, 3),
          (2, 4),
          (2, 5),
          (2, 6),
          (3, 3),
          (3, 4),
          (3, 5),
          (3, 6),
          (4, 3),
          (4, 4),
          (4, 5),
          (4, 6)
        )
      }
    }
    "calculate intersections" should {
      "return true for intersecting" in {
        val subject = Claim(1, 1, 3, 4, 4)
        val other   = Claim(2, 3, 1, 4, 4)
        val actual  = subject.doesIntersectWith(other)
        actual shouldBe true
      }
      "return false for not intersecting" in {
        val subject = Claim(1, 1, 3, 4, 4)
        val other   = Claim(3, 5, 5, 2, 2)
        val actual  = subject.doesIntersectWith(other)
        actual shouldBe false
      }
    }
  }
}
