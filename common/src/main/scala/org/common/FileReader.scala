package org.common
import scala.io.Source
import scala.util.Try

object FileReader {
  def read(filename: String): Try[Seq[String]] = Try(Source.fromResource(filename).getLines().toSeq)
}
