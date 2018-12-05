package org.common
import org.scalatest.{ Matchers, WordSpec }

class FileReaderTest extends WordSpec with Matchers {
  "FileReader" must {
    "process an input file" should {
      "read file and create list of lines" in {
        val filename = "test-lines.txt"
        val actual   = FileReader.read(filename).get
        actual shouldBe Seq("1.line", "2.line", "3.line")
      }
    }
  }
}
