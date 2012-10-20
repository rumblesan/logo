package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object SierpinskiTriangle {

  val rules  = new LSystemRules().addSub('A', "B-A-B")
                                 .addSub('B', "A+B+A")

  val startAngle = 90.0

  val angle = 60.0

  val seed = "A"

  def apply(distance: Double) = {
    new SierpinskiTriangle(distance)
  }

}

class SierpinskiTriangle(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case 'A' => turtle.move(dist)
          case 'B' => turtle.move(dist)
          case '+' => turtle.turn(-SierpinskiTriangle.angle)
          case '-' => turtle.turn(SierpinskiTriangle.angle)
          case _ => turtle
        }
      }
    )

  }

}

