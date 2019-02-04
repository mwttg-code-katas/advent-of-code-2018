package org.slice.it
import scala.collection.immutable.HashMap

class Initializer {
  var map = HashMap.empty[String, String]

}

object Initializer {

  def apply(key: String, value: String): Unit =
    Initializer.map = createStuff(key, value)

  private def createStuff(key: String, value: String): HashMap[String, String] =
    HashMap(key -> value)
}
