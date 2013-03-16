package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object DragonCurve {

  val rules  = new LSystemRules().addSub('X', "X+YF")
                                 .addSub('Y', "FX-Y")

  val startAngle = 0

  val angle = 90.0

  val seed = "FX"

  def apply(distance: Double) = {
    new DragonCurve(distance)
  }

}

class DragonCurve(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case 'F' => turtle.move(dist)
          case '-' => turtle.yaw(-DragonCurve.angle)
          case '+' => turtle.yaw(DragonCurve.angle)
          case _ => turtle
        }
      }
    )

  }

}

