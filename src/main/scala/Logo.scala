import processing.core._
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

  val lineSize = 5.0

  val system = HilbertCurve

  override def setup {
    size(1024, 768)
    smooth()
    frameRate(30)

    ls = new LSystem(system.seed, system.rules)

  }

  override def draw {

    background(0)
    stroke(255)

    val turtle = new Turtle(width * 0.05, height * 0.85, system.startAngle, this)

    system(lineSize).parse(ls, turtle)

  }

  override def mouseClicked() {
    ls = ls.nextGeneration()
    println(ls.chars)
  }

}

