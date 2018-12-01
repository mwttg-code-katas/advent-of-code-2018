package org.chronal.calibration

object Puzzle2 extends App {
  val calibrator     = new Calibrator
  val inputFile      = "frequency.txt"
  val startFrequency = 0
  calibrator.start2(startFrequency, inputFile)
}
