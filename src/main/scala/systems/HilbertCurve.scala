package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object HilbertCurve {

  val rules  = new LSystemRules().addSub('A', "-BF+AFA+FB-")
                                 .addSub('B', "+AF-BFB-FA+")

  val startAngle = 180.0

  val angle = 90.0

  val seed = "A"

  def apply(distance: Double) = {
    new HilbertCurve(distance)
  }

}

class HilbertCurve(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case 'F' => turtle.move(dist)
          case '-' => turtle.yaw(-HilbertCurve.angle)
          case '+' => turtle.yaw(HilbertCurve.angle)
          case _ => turtle
        }
      }
    )

  }

}

