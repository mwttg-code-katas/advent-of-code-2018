package org.slice.it

object InitializerTest extends App {
  println(Initializer.map.size)

  Initializer("test", "333ß")
  println(Initializer.map.size)

}
