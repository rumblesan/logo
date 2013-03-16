import processing.core._
import spde.core._
import PConstants._

import java.awt.event.KeyEvent._

import com.rumblesan.logo.turtle._
import com.rumblesan.lsystem._

import peasy._


object Main {
  def main(args: Array[String]) = {
    PApplet.main(
      Array("Logo")
    )
  }
}

class Logo extends PApplet {

  implicit def double2Float(v: Double) = v.toFloat

  var ls: LSystem = _

  val lineSize = 20.0

  var cam: PeasyCam = _

  val system = HilbertCurve3D

  override def setup {
    size(1024, 768, P3D)
    smooth()
    frameRate(30)

    ls = new LSystem(system.seed, system.rules)

    cam = new PeasyCam(this, 0, 0, 0, 50)
  }

  override def draw {

    background(0)
    stroke(255)

    val turtle = new Turtle(width * 0.05, height * 0.85, 0.0, 0.0, system.startAngle, this)

    system(lineSize).parse(ls, turtle)

  }

  override def keyPressed() {
    key match {
      case VK_SPACE => ls = ls.nextGeneration()
      case _ => {}
    }
  }

}

