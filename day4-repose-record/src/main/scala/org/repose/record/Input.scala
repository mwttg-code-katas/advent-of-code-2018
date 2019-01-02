package org.repose.record
import org.common.FileReader

class Input {}

object Input {
  def getFileLinesSorted(filename: String): Seq[FileLine] = {
    val lines = FileReader.read(filename).get
    lines.map(line => FileLine.createFrom(line)).sorted
  }

  def getGuardRelated(lines: Seq[FileLine]): Seq[Seq[FileLine]] = {
    val resultBuilder = Seq.newBuilder[Seq[FileLine]]
    val recordBuilder = Seq.newBuilder[FileLine]

    for (line <- lines) {
      val FileLine(_, content) = line
      content match {
        case x if x.startsWith("Guard") =>
          resultBuilder += recordBuilder.result()
          recordBuilder.clear()
          recordBuilder += line
        case x if x.startsWith("falls") || x.startsWith("wakes") =>
          recordBuilder += line
      }
    }
    resultBuilder.result()
  }

  def createGuardRecord(input: Seq[Seq[FileLine]]) = {}

}
