package org.repose.record
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

final case class FileLine(date: LocalDateTime, content: String) extends Ordered[FileLine] {

  override def compare(that: FileLine): Int =
    if (this.date.isBefore(that.date))
      -1
    else if (this.date.isAfter(that.date))
      1
    else
      0
}

object FileLine {
  private val Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

  def createFrom(line: String): FileLine = {
    val date    = line.substring(1, 17)
    val content = line.substring(19, line.length)
    FileLine(LocalDateTime.parse(date, Formatter), content)
  }
}
