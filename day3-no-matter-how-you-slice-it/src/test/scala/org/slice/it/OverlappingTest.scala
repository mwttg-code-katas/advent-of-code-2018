package org.slice.it
import org.scalatest.{ Matchers, WordSpec }

class OverlappingTest extends WordSpec with Matchers {
  "Puzzle 3" must {
    val subject = new Overlapping

    "process a file line" should {
      "extract numbers from a line" in {
        val input  = "#123 @ 3,2: 5x4"
        val actual = subject.extract(input)
        actual shouldBe Array("123", "3", "2", "5", "4")
      }
      "extract an rectangle" in {
        val input  = Array("123", "3", "2", "8", "6")
        val actual = Rectangle.from(input)
        actual shouldBe Rectangle(123, 3, 2, 11, 8)
      }
    }
  }
}
