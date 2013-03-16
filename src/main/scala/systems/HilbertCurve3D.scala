package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object HilbertCurve3D {

  val rules  = new LSystemRules().addSub('X', "XF+XF-XFvXF^XF")

  val startAngle = 180.0

  val angle = 90.0

  val seed = "X"

  def apply(distance: Double) = {
    new HilbertCurve3D(distance)
  }

}

class HilbertCurve3D(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case 'F' => turtle.move(dist)
          case '-' => turtle.yaw(-HilbertCurve3D.angle)
          case '+' => turtle.yaw(HilbertCurve3D.angle)
          case '^' => turtle.pitch(HilbertCurve3D.angle)
          case 'v' => turtle.pitch(-HilbertCurve3D.angle)
          case _ => turtle
        }
      }
    )

  }

}

