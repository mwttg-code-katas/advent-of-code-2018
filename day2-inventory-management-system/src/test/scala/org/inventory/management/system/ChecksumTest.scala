package org.inventory.management.system
import org.scalatest.{ Matchers, WordSpec }

class ChecksumTest extends WordSpec with Matchers {
  "Puzzle 2" must {
    val subject = new Checksum

    "process a box id" should {
      "generate a (letter, count) tuple" in {
        val boxId  = "aabbbc"
        val actual = subject.generateCounts(boxId)
        actual shouldBe Array(('a', 2), ('b', 3), ('c', 1))
      }
    }

    "analyze the (letter, count) tuples" should {
      "identify letter appears exactly two times (valid input)" in {
        val tuples = Array(('a', 2))
        val actual = subject.twoTimes(tuples)
        actual shouldBe 1
      }
      "identify letter appears exactly two times (invalid input)" in {
        val tuples = Array(('a', 1))
        val actual = subject.twoTimes(tuples)
        actual shouldBe 0
      }
      "identify letter appears exactly three times (valid input)" in {
        val tuples = Array(('a', 3))
        val actual = subject.threeTimes(tuples)
        actual shouldBe 1
      }
      "identify letter appears exactly three times (invalid input)" in {
        val tuples = Array(('a', 1))
        val actual = subject.threeTimes(tuples)
        actual shouldBe 0
      }
    }

    "analyze a boxId" should {
      "generate a two-times, three-times tuple, for aa" in {
        val input  = "aa"
        val actual = subject.scanBoxId(input)
        actual shouldBe (1, 0)
      }
      "generate a two-times, three-times tuple, for aaa" in {
        val input  = "aaa"
        val actual = subject.scanBoxId(input)
        actual shouldBe (0, 1)
      }
      "generate a two-times, three-times tuple, for a" in {
        val input  = "a"
        val actual = subject.scanBoxId(input)
        actual shouldBe (0, 0)
      }
      "generate a two-times, three-times tuple, for aa and bbb" in {
        val input  = "aabbbc"
        val actual = subject.scanBoxId(input)
        actual shouldBe (1, 1)
      }
      "generate a two-times, three-times tuple with a real boxId" in {
        val input  = "megsdwpnlhrinkatfqoysxcbvq"
        val actual = subject.scanBoxId(input)
        actual shouldBe (1, 0)
      }
    }

    "read the input file" should {
      "generate a Seq of boxIds" in {
        val filename = "text.txt"
        val actual   = subject.readFile(filename).get
        actual shouldBe Seq("1. line", "2. line", "3. line")
      }
    }

    "process the boxIds" should {
      "generate a Seq of (twoTimes, threeTimes) tuples" in {
        val content = Seq("aa", "bbb", "c", "ee", "fff", "ggg")
        val actual  = subject.processIds(content)
        actual shouldBe Seq((1, 0), (0, 1), (0, 0), (1, 0), (0, 1), (0, 1))
      }
      "sum up the tuples" in {
        val tuples = Seq((1, 0), (0, 1), (0, 0), (1, 0), (0, 1), (0, 1))
        val actual = subject.sumUp(tuples)
        actual shouldBe (2, 3)
      }

    }
  }
}
