package org.memory.maneuver
import org.common.FileReader

class RawData {}

object RawData {
  def apply(filename: String) = {
    val lines = FileReader.read(filename).get
    lines.head.split(" ").map(x => x.toInt).toList
  }
}
/*

recursive nodes aufbauen

search node

createNode(rawData, childNodeSize, position)

 */
