package org.chronal.calibration

object Puzzle1 extends App {
  val calibrator     = new Calibrator
  val inputFile      = "frequency.txt"
  val startFrequency = 0
  val result         = calibrator.start(startFrequency, inputFile)
  println(s"The current Frequency is $result")
}
