package org.marble.mania

final case class Marbles(currentMarbleNumber: Int = 2, lastIndex: Int = 0) {
  def next(): Marbles = {
    val newCurrentMarbleNumber = currentMarbleNumber + 1
    Marbles(newCurrentMarbleNumber, lastIndex)
  }

  def next(newIndex: Int): Marbles = {
    val newCurrentMarbleNumber = currentMarbleNumber + 1
    Marbles(newCurrentMarbleNumber, newIndex)
  }
}
