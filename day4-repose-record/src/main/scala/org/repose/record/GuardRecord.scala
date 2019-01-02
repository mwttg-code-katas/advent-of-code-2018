package org.repose.record
import java.time.LocalDateTime

import scala.collection.mutable

final case class GuardRecord(id: Int, date: LocalDateTime, shiftTable: Array[Int]) {

  def minutesAsleep(): Int = {
    var asleep = 0
    for (item <- shiftTable) {
      if (item == 1)
        asleep = asleep + 1
    }
    asleep
  }
}

object GuardRecord {
  private val Awake: Int = 0
  private val Sleep: Int = 1

  def createFrom(input: Seq[FileLine]): GuardRecord = {
    val id         = extractId(input)
    val date       = extractDate(input)
    val shiftTable = createShiftTable(input)
    new GuardRecord(id, date, shiftTable)
  }

  private def extractId(input: Seq[FileLine]) = {
    val pattern = "[0-9]+".r
    val id      = pattern.findFirstIn(input.head.content).get.toInt
    id
  }

  private def extractDate(input: Seq[FileLine]) =
    if (input.size == 1)
      input.head.date
    else
      input(2).date

  // AWAKE = 0 - SLEEP = 1
  private def createShiftTable(input: Seq[FileLine]) = {
    val original   = new Array[Int](60)
    val newInput   = input.drop(1)
    val sleepAwake = newInput.map(item => item.date.getMinute)

    val builder = new mutable.ArrayBuilder.ofInt() //.newBuilder[Int]
    builder.sizeHint(60)

    for (item <- sleepAwake) {
      original(item) = if (sleepAwake.indexOf(item) % 2 == 0) 1 else 2
    }

    val result = new Array[Int](60)
    var mode   = Awake
    for (index <- 0 to 59) {
      if (original(index) == 1)
        mode = Sleep
      if (original(index) == 2)
        mode = Awake

      result(index) = mode
    }

    result
  }
}
