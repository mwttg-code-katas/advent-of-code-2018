package org.stars

final case class Position(x: Int, y: Int) {
  def move(velocity: Velocity): Position = {
    val Velocity(deltaX, deltaY) = velocity
    val newX                     = x + deltaX
    val newY                     = y + deltaY
    Position(newX, newY)
  }
}
