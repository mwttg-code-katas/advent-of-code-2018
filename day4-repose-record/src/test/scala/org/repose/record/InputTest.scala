package org.repose.record
import java.time.LocalDateTime

import org.scalatest.{ Matchers, WordSpec }

import scala.collection.mutable

class InputTest extends WordSpec with Matchers {
  "Input" must {
    "#getFileLinesSorted" should {
      "return sorted file lines" in {
        val filename = "test-line-date.txt"
        val actual   = Input.getFileLinesSorted(filename)
        actual should contain theSameElementsInOrderAs Seq(
          FileLine(LocalDateTime.of(1518, 1, 18, 0, 50), "Line 1"),
          FileLine(LocalDateTime.of(1518, 2, 18, 0, 30), "Line 2"),
          FileLine(LocalDateTime.of(1518, 3, 18, 0, 10), "Line 3"),
          FileLine(LocalDateTime.of(1518, 5, 18, 0, 20), "Line 4"),
          FileLine(LocalDateTime.of(1518, 7, 18, 0, 40), "Line 5")
        )
      }
      "lalala" in {
        val filename = "test-input.txt"
        val lines    = Input.getFileLinesSorted(filename)
        val test     = Input.getGuardRelated(lines)
        val test2    = test.drop(1)

        val test3 = test2.map(item => GuardRecord.createFrom(item))

        test2.head.foreach(println)
        test3.head.shiftTable.foreach(println)
        println(test3.head.minutesAsleep())

        var guards = new mutable.HashMap[Int, Seq[GuardRecord]]
        for (record <- test3) {
          val id = record.id
          if (guards.keySet.contains(id)) {
            val orig   = guards(id)
            val newRec = orig :+ record
            guards += (id -> newRec)
          } else {
            guards += (id -> Seq(record))
          }

        }

        println(guards)

        var minutes = new mutable.HashMap[Int, Int]
        guards.foreach(item => {
          val id  = item._1
          val sum = item._2.map(record => record.minutesAsleep()).toList.sum

          minutes += (id -> sum)
        })

        val maxMinutes = minutes.valuesIterator.max
        // Its Guard with id =  641  --> 498 minutes

        val guard641Records = guards(641)

        for (minute <- 0 to 59) {
          var count = 0

          for (record <- guard641Records) {
            if (record.shiftTable(minute) == 1)
              count = count + 1
          }
          println(s"minute: $minute --- count: $count")
        }

        // It's minute 41 with 15 times

        println(s"Guard:")
      }
    }
  }
}
