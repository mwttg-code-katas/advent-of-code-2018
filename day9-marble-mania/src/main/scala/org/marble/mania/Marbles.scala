package org.marble.mania

final case class Marbles(currentMarble: Int, currentIndex: Int) {
  def next(): Marbles = {
    val newCurrentMarble = currentMarble + 1
    Marbles(newCurrentMarble, currentIndex)
  }

  def next(newIndex: Int): Marbles = {
    val newCurrentMarble = currentMarble + 1
    Marbles(newCurrentMarble, newIndex)
  }
}
