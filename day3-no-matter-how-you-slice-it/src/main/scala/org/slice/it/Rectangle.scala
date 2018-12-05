package org.slice.it

final case class Rectangle(id: Int, top: Int, left: Int, bottom: Int, right: Int) {}

object Rectangle {
  def from(numbers: Array[String]): Rectangle = {
    require(numbers.length == 5, "invalid line format!")
    Rectangle(
      numbers(0).toInt,
      numbers(1).toInt,
      numbers(2).toInt,
      numbers(3).toInt + numbers(1).toInt,
      numbers(4).toInt + numbers(2).toInt
    )
  }
}
