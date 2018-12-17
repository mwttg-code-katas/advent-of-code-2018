package org.stars

final case class Star(position: Position, velocity: Velocity) {
  def next(): Star = {
    val newPosition = position.move(velocity)
    Star(newPosition, velocity)
  }
}
