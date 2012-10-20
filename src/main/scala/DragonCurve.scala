package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object DragonCurve {

  val rules  = new LSystemRules().addSub('X', "X+YF")
                                 .addSub('Y', "FX-Y")

  val angle = 90.0
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

