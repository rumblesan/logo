import processing.core._
import spde.core._
import PConstants._

import com.rumblesan.logo.turtle._
import com.rumblesan.lsystem._

object Main {
  def main(args: Array[String]) = {
    PApplet.main(
      Array("Logo")
    )
  }
}

class Logo extends PApplet {

  var ls: LSystem = _

  val dc = new DragonCurve(10.0)

  override def setup {
    size(1024, 768)
    smooth()
    frameRate(30)

    ls = new LSystem("FX".toList, DragonCurve.rules)

  }

  override def draw {

    background(0)
    stroke(255)

    val turtle = new Turtle(width * 0.75, height * 0.75, 0.0, this)

    dc.parse(ls, turtle)

  }

  override def mouseClicked() {
    ls = ls.nextGeneration()
    println(ls.chars)
  }

}

