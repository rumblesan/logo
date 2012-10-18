import processing.core._
import spde.core._
import PConstants._

import com.rumblesan.turtle._

object StraightScalaRunner {
  def main(args: Array[String]) = {
    PApplet.main(
      Array("Penrose")
    )
  }
}

class Penrose extends PApplet {

  override def setup {
    size(1024, 768)
    smooth()
    frameRate(30)

    background(0)
    stroke(255)

  }

  override def draw {

    val turtle = new Turtle(width / 2, height / 2, 0.0f, this)

    turtle.move(20).turn(10).move(20).turn(30).move(40)

  }

}

