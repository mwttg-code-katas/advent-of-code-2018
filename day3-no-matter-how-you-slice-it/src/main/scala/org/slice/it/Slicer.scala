package org.slice.it
import org.common.FileReader

class Slicer {}

object Slicer {
  def getClaimsFrom(filename: String): Seq[Claim] = {
    val lines = FileReader.read(filename).get
    lines.map(Claim.createFrom)
  }

  // Not the fastest but readable and FP :)
  def testClaim(claim: Claim, claims: Seq[Claim]): Boolean = {
    val testItems     = claims.filter(item => item != claim)
    val intersections = testItems.map(item => item.doesIntersectWith(claim))
    intersections.find(item => item == true).getOrElse(false)
  }
}
