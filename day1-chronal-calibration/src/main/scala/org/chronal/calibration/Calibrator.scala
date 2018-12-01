package org.chronal.calibration
import scala.io.Source
import scala.util.Try

class Calibrator {
  def readInput(text: String): Array[String] = text.split(",").map(item => item.replaceAll("\\s", ""))

  def createTuples(input: Array[String]): Array[(String, String)] = for (item <- input) yield item.splitAt(1)

  def createCurrentFrequency(startFrequency: Int, tuple: (String, String)): Int =
    tuple._1 match {
      case "+" => startFrequency + tuple._2.toInt
      case "-" => startFrequency - tuple._2.toInt
      case _ => throw new IllegalArgumentException("Wrong Operator")
    }

  def calibrate(startFrequency: Int, tuples: Array[(String, String)]): Int =
    tuples.map(item => createCurrentFrequency(startFrequency, item)).sum

  def readFile(filename: String): Try[String] =
    Try(Source.fromResource(filename).getLines().mkString(","))

  def start(startFrequency: Int, inputFile: String): Int = {
    val fileContent = readFile(inputFile).get
    val stringArray = readInput(fileContent)
    val tuples      = createTuples(stringArray)
    calibrate(startFrequency, tuples)
  }
}
