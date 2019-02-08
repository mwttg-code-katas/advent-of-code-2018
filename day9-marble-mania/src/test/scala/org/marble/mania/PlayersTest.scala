package org.marble.mania
import org.scalatest.{ Matchers, WordSpec }

class PlayersTest extends WordSpec with Matchers {

  "Players" should {
    "initialize" in {
      val actual = Players().initialize(3)

      val pointsPerPlayer = Map(1 -> 0, 2 -> 0, 3 -> 0)
      val expected        = Players(pointsPerPlayer)
      actual shouldBe expected
    }
    "nextPlayer" in {
      val pointsPerPlayer = Map(1 -> 0, 2 -> 0, 3 -> 0)

      val actual   = Players(pointsPerPlayer).nextPlayer()
      val expected = Players(pointsPerPlayer, 2)
      actual shouldBe expected
    }
    "addPoints" in {
      val pointsPerPlayer = Map(1 -> 0, 2 -> 33, 3 -> 0)
      val actual          = Players(pointsPerPlayer, 2).addPoints(66)

      val newPointsPerPlayer = Map(1 -> 0, 2 -> 99, 3 -> 0)
      val expected           = Players(newPointsPerPlayer, 2)
      actual shouldBe expected
    }
  }

}
