package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object HilbertCurve {

  val rules  = LSystemRules(('A', "-BF+AFA+FB-"), ('B', "+AF-BFB-FA+"))

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
          case '-' => turtle.turn(-HilbertCurve.angle)
          case '+' => turtle.turn(HilbertCurve.angle)
          case _ => turtle
        }
      }
    )

  }

}

