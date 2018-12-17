package org.repose.record
import org.scalatest.{ Matchers, WordSpec }

class GetInputTest extends WordSpec with Matchers {
  "GetInput" must {
    "read a file" should {
      "create content sorted" in {
        val filename = "test-line-date.txt"
        val actual   = GetInput(filename)
//        actual shouldBe Seq(
//          (LocalDateTime.of(1518, 1, 18, 0, 50), "Line 1"),
//          (LocalDateTime.of(1518, 2, 18, 0, 30), "Line 2"),
//          (LocalDateTime.of(1518, 3, 18, 0, 10), "Line 3"),
//          (LocalDateTime.of(1518, 5, 18, 0, 20), "Line 4"),
//          (LocalDateTime.of(1518, 7, 18, 0, 40), "Line 5")
//        )
      }
    }
  }

}
