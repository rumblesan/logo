package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object DragonCurve {

  val rules  = LSystemRules(('X', "X+YF"), ('Y', "FX-Y"))

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
          case '-' => turtle.turn(-DragonCurve.angle)
          case '+' => turtle.turn(DragonCurve.angle)
          case _ => turtle
        }
      }
    )

  }

}

