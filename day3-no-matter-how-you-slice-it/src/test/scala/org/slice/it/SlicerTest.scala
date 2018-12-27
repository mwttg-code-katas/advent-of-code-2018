package org.slice.it
import org.scalatest.{ Matchers, WordSpec }

class SlicerTest extends WordSpec with Matchers {
  "Slicer" must {
    "generate data" should {
      "create Claims" in {
        val filename = "test-data.txt"
        val actual   = Slicer.getClaimsFrom(filename)
        actual shouldBe Seq(
          Claim(1, 37, 526, 17, 23),
          Claim(2, 75, 649, 23, 11),
          Claim(3, 138, 364, 29, 12)
        )
      }
    }
  }
}
