package org.repose.record
import java.time.LocalDateTime

import org.scalatest.{ Matchers, WordSpec }

class FileLineTest extends WordSpec with Matchers {
  "FileLine" must {
    "created from a line" should {
      "extract date and content from a line" in {
        val input    = "[1518-03-18 00:03] little String"
        val actual   = FileLine.createFrom(input)
        val expected = FileLine(LocalDateTime.of(1518, 3, 18, 0, 3), "little String")
        actual shouldBe expected
      }
    }
    "sorting" should {
      "sort the lines from old to new" in {
        val line1  = FileLine.createFrom("[1518-03-18 00:03] new")
        val line2  = FileLine.createFrom("[1518-03-19 00:03] newer")
        val line3  = FileLine.createFrom("[1518-03-20 00:03] newest")
        val lines  = Seq(line3, line2, line1)
        val sorted = lines.sorted
        sorted should contain theSameElementsInOrderAs Seq(line1, line2, line3)
      }
    }
  }
}
