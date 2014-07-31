package com.rumblesan.lsystem

import com.rumblesan.logo.turtle._

object PenroseRhombus {

  val rules  = LSystemRules(
    ('6', "81++91----71[-81----61]++"),
    ('7', "+81--91[---61--71]+"),
    ('8', "-61++71[+++81++91]-"),
    ('9', "--81++++61[+91++++71]--71"),
    ('1', "")
  )

  val startAngle = 0

  val angle = 36.0

  val seed = "[7]++[7]++[7]++[7]++[7]++"

  def apply(distance: Double) = {
    new PenroseRhombus(distance)
  }

}

class PenroseRhombus(distance: Double) {

  val dist = distance

  def parse(lsystem: LSystem, turtle: Turtle): Unit = {

    lsystem.chars.foldLeft(turtle)(
      (turtle, char) => {
        char match {
          case '1' => turtle.move(dist)
          case '-' => turtle.turn(-PenroseRhombus.angle)
          case '+' => turtle.turn(PenroseRhombus.angle)
          case '[' => turtle.pushPos()
          case ']' => turtle.popPos()
          case _ => turtle
        }
      }
    )

  }

}

