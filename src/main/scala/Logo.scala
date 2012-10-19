import processing.core._
import spde.core._
import PConstants._

import com.rumblesan.logo.turtle._

object Main {
  def main(args: Array[String]) = {
    PApplet.main(
      Array("Logo")
    )
  }
}

class Logo extends PApplet {

  override def setup {
    size(1024, 768)
    smooth()
    frameRate(30)

    background(0)
    stroke(255)

  }

  override def draw {

    val turtle = new Turtle(width / 2, height / 2, 0.0, this)

    turtle.move(20).turn(10).move(20).turn(30).move(40)

  }

}

