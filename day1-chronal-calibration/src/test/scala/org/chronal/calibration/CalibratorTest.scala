package org.chronal.calibration
import org.scalatest.{ Matchers, WordSpec }

class CalibratorTest extends WordSpec with Matchers {
  "Puzzle 1" must {
    val subject = new Calibrator

    "read a string and extract the segments, separated by ','" should {
      "create a valid output Array for a valid input String" in {
        val input  = "a, b, c"
        val actual = subject.readInput(input)
        actual shouldBe Array("a", "b", "c")
      }
      "create an empty output Array for an empty input" in {
        val input  = ""
        val actual = subject.readInput(input)
        actual shouldBe Array("")
      }
    }

    "create a list of tuples from the String Array" should {
      "create a valid tuple list, for a valid input" in {
        val input       = "+1, +2, +3"
        val stringArray = subject.readInput(input)
        val actual      = subject.createTuples(stringArray)
        actual shouldBe Array(("+", "1"), ("+", "2"), ("+", "3"))
      }
    }

    "calibrate the current frequency" should {
      "create the current frequency, for valid input (+)" in {
        val startFrequency = 0
        val tuple          = ("+", "1")
        val actual         = subject.createCurrentFrequency(startFrequency, tuple)
        actual shouldBe 1
      }
      "create the current frequency, for valid input (-)" in {
        val startFrequency = 10
        val tuple          = ("-", "5")
        val actual         = subject.createCurrentFrequency(startFrequency, tuple)
        actual shouldBe 5
      }
      "throw an IllegalArgumentException, for a unknown operator" in {
        val startFrequency = 0
        val tuple          = ("/", "1")
        an[IllegalArgumentException] should be thrownBy subject.createCurrentFrequency(startFrequency, tuple)
      }
      "throw an NumberFormatException, for an unknown number" in {
        val startFrequency = 0
        val tuple          = ("+", "a")
        an[NumberFormatException] should be thrownBy subject.createCurrentFrequency(startFrequency, tuple)
      }
      "set the right frequency" in {
        val input       = "+1, +2, +3"
        val stringArray = subject.readInput(input)
        val tuples      = subject.createTuples(stringArray)
        val actual      = subject.calibrate(0, tuples)
        actual shouldBe 6
      }
    }

    "read an input file" should {
      "create the right string" in {
        // that happens when you begin to code and read the whole information later
        val inputFile = "test-frequency.txt"
        val actual    = subject.readFile(inputFile).get
        actual shouldBe "+1,+2,-3"
      }
      "throw an NullPointerException, if file does not exist" in {
        val inputFile = "file-does-not-exist"
        an[NullPointerException] should be thrownBy subject.readFile(inputFile).get
      }
    }
  }
}
