package com.rumblesan.logo.turtle

import processing.core._

import scala.math._

object Turtle {

  implicit def double2Float(v: Double) = v.toFloat

}

class Turtle(xStart: Double, yStart: Double, headAngle: Double, pApplet: PApplet) {

  import Turtle._

  val x = xStart
  val y = yStart

  // radians
  val heading = headAngle

  val pa = pApplet

  def deg2Rad(degree: Double): Double = {
    ((degree * 2 * Pi) / 360)
  }

  def move(distance: Double): Turtle = {
    val xDelta = sin(heading) * distance
    val yDelta = cos(heading) * distance

    val x2 = x + xDelta
    val y2 = y + yDelta

    pa.line(x, y, x2, y2)

    new Turtle(x2, y2, heading, pa)
  }

  def turn(angle: Double): Turtle = {
    val rads = deg2Rad(angle) + heading
    new Turtle(x, y, rads, pa)
  }
  

}

