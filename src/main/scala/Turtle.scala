package com.rumblesan.logo.turtle

import processing.core._

import scala.math._

class Turtle(xStart: Float, yStart: Float, headAngle: Float, pApplet: PApplet) {

  val x = xStart
  val y = yStart

  // radians
  val heading = headAngle

  val pa = pApplet

  def deg2Rad(degree: Float): Float = {
    ((degree * 2 * Pi) / 360).toFloat
  }

  def move(distance: Float): Turtle = {
    val xDelta = sin(heading).toFloat * distance
    val yDelta = cos(heading).toFloat * distance

    val x2 = x + xDelta
    val y2 = y + yDelta

    pa.line(x, y, x2, y2)

    new Turtle(x2, y2, heading, pa)
  }

  def turn(angle: Float): Turtle = {
    val rads = deg2Rad(angle) + heading
    new Turtle(x, y, rads, pa)
  }
  

}

