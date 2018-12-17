package org.stars

import java.awt.Color
import java.awt.image.BufferedImage

import scala.language.reflectiveCalls

//from https://rosettacode.org/wiki/Draw_a_pixel#Scala
class RgbBitmap(val dim: (Int, Int)) {
  def width: Int  = dim._1
  def height: Int = dim._2

  private val image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR)

  def apply(x: Int, y: Int) = new Color(image.getRGB(x, y))

  def update(x: Int, y: Int, c: Color): Unit = image.setRGB(x, y, c.getRGB)

  def fill(c: Color): Unit = {
    val g = image.getGraphics
    g.setColor(c)
    g.fillRect(0, 0, width, height)
  }

  def getImage(): BufferedImage =
    image

  def saveImage(filename: String) =
    javax.imageio.ImageIO.write(image, "png", new java.io.File(filename))

}

object RgbBitmap {
  def apply(width: Int, height: Int) = new RgbBitmap(width, height)
}
