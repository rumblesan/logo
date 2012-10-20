package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object FractalPlant {

  val rules  = new LSystemRules().addSub('X', "F-[[X]+X]+F[+FX]-X")
                                 .addSub('F', "FF")

  val startAngle = 110.0

  val angle = 25.0

  val seed = "X"

  def apply(distance: Double) = {
    new FractalPlant(distance)
  }

}

class FractalPlant(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case 'F' => turtle.move(dist)
          case '-' => turtle.turn(-FractalPlant.angle)
          case '+' => turtle.turn(FractalPlant.angle)
          case '[' => turtle.pushPos()
          case ']' => turtle.popPos()
          case _ => turtle
        }
      }
    )

  }

}

