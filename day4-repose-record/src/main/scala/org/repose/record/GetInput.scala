package org.repose.record
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.common.FileReader
import org.repose.record.GetInput.Formatter

class GetInput(filename: String) {
  private def extractDate(line: String): LocalDateTime = {
    val dateString = line.substring(1, 17)
    LocalDateTime.parse(dateString, Formatter)
  }

  private def extractContent(line: String): String =
    line.substring(19, line.length)

  private def extractLine(line: String): (LocalDateTime, String) = {
    val date    = extractDate(line)
    val content = extractContent(line)
    (date, content)
  }

  private def sortItems(items: Seq[(LocalDateTime, String)]): Seq[(LocalDateTime, String)] =
    items.sortWith((x, y) => x._1.isBefore(y._1))

  private def getInput: Seq[(LocalDateTime, String)] = {
    val lines   = FileReader.read(filename).get
    val content = lines.map(item => extractLine(item))
    sortItems(content)
  }
}

object GetInput {
  private val Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

  def apply(filename: String): Seq[(LocalDateTime, String)] = {
    val actual = new GetInput(filename)
    actual.getInput
  }
}
