package org.slice.it
import org.scalatest.{ Matchers, WordSpec }

class SliceIntersectionTest extends WordSpec with Matchers {
  "Puzzle 3" must {
    val subject = new SliceIntersection

    "process an input file" should {
      // perhaps it's time to extract such a function to a common module
      "read file and create list of lines" in {
        val filename = "test-lines.txt"
        val actual   = subject.readFile(filename).get
        actual shouldBe Seq("1.line", "2.line", "3.line")
      }
      "read file and extract rectangles from it" in {
        val filename = "test-data.txt"
        val actual   = subject.getRectangles(filename)
        actual shouldBe Seq(
          Rectangle(1, 37, 526, 54, 549),
          Rectangle(2, 75, 649, 98, 660),
          Rectangle(3, 138, 364, 167, 376)
        )
      }
    }

    "process a file line" should {
      "extract numbers from a line" in {
        val input  = "#123 @ 3,2: 5x4"
        val actual = subject.extract(input)
        actual shouldBe Array("123", "3", "2", "5", "4")
      }
      "extract an rectangle" in {
        val input  = Array("123", "3", "2", "8", "6")
        val actual = subject.createRectangleFrom(input)
        actual shouldBe Rectangle(123, 3, 2, 11, 8)
      }
    }

    "Rectangle" should {
      //missing test (4 edges) :/
      "check if intersect another rectangle (positive test)" in {
        val rect1  = Rectangle(1, 1, 1, 10, 10)
        val rect2  = Rectangle(2, 5, 5, 15, 15)
        val actual = rect1.isIntersecting(rect2)
        actual shouldBe true
      }
      "check if intersect another rectangle (negative test)" in {
        val rect1  = Rectangle(1, 1, 1, 5, 5)
        val rect2  = Rectangle(2, 6, 5, 15, 15)
        val actual = rect1.isIntersecting(rect2)
        actual shouldBe false
      }
      "check besides" in {
    val rect1  = Rectangle(1, 1, 1, 2, 2)
    val rect2  = Rectangle(2, 2, 1, 3, 2)
    val actual = rect1.isIntersecting(rect2)
    actual shouldBe false
  }

      "disassemble a rectangle" in {
        val rect1 = Rectangle(1, 1, 1, 3, 3)
        val actual = rect1.disassemble()
        actual should contain allElementsOf Seq(
          Rectangle(1, 1, 1, 2, 2),
          Rectangle(1, 2, 1, 3, 2),
          Rectangle(1, 1, 2, 2, 3), Rectangle(1, 2, 2, 3, 3))
      }


      "calculate the intersection area (positive)" in {
        val rect1  = Rectangle(1, 1, 1, 10, 10)
        val rect2  = Rectangle(2, 5, 5, 15, 15)
        val actual = rect1.getIntersectionArea(rect2)
        actual shouldBe 25
      }
      "calculate the intersection area (positive test 2)" in {
        val rect1  = Rectangle(2, 5, 5, 15, 15)
        val rect2  = Rectangle(1, 1, 1, 10, 10)
        val actual = rect1.getIntersectionArea(rect2)
        actual shouldBe 25
      }
    }
  }
}
