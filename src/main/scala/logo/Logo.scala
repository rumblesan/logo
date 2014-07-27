package com.rumblesan.logo

import processing.core._
import PConstants._

import com.rumblesan.logo.turtle._
import com.rumblesan.lsystem._
import com.rumblesan.logo.turtle.Turtle.double2Float

class Logo extends PApplet {

  lazy val system = HilbertCurve

  // Needs to be a var because it gets changed on each
  // mouse click
  var ls: LSystem = LSystem(system.seed, system.rules)

  lazy val lineSize = 5.0

  lazy val turtle = Turtle(
    width * 0.05,
    height * 0.85,
    system.startAngle,
    Nil,
    this
  )

  override def setup {
    size(1024, 768)
    smooth()
    frameRate(30)
  }

  override def draw {

    background(0)
    stroke(255)

    system(lineSize).parse(ls, turtle)

  }

  override def mouseClicked() {
    ls = ls.nextGeneration()
    println(ls.chars)
  }

}

