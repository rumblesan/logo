package com.rumblesan.logo.turtle

import processing.core._

import scala.math._

object Turtle {

  implicit def double2Float(v: Double) = v.toFloat

}

case class StackInfo(x: Double, y: Double, heading: Double)

class Turtle(xVal: Double, yVal: Double, headAngle: Double, stateStack: List[StackInfo], pApplet: PApplet) {

  import Turtle._

  def this(xVal: Double, yVal: Double, headAngle: Double, pApplet: PApplet) = {
    this(xVal, yVal, headAngle, Nil, pApplet)
  }

  def this(xVal: Double, yVal: Double, pApplet: PApplet) = {
    this(xVal, yVal, 0.0, Nil, pApplet)
  }

  val x = xVal
  val y = yVal

  val stack = stateStack

  val heading = headAngle

  val pa = pApplet

  def deg2Rad(degree: Double): Double = {
    ((degree * 2 * Pi) / 360)
  }

  def move(distance: Double): Turtle = {
    val xDelta = sin(deg2Rad(heading)) * distance
    val yDelta = cos(deg2Rad(heading)) * distance

    val x2 = x + xDelta
    val y2 = y + yDelta

    pa.line(x, y, x2, y2)

    new Turtle(x2, y2, heading, stack, pa)
  }

  def turn(angle: Double): Turtle = {
    new Turtle(x, y, angle + heading, stack, pa)
  }

  def pushPos(): Turtle = {
    val newStack = StackInfo(x, y, heading) :: stack
    new Turtle(x, y, heading, newStack, pa)
  }

  def popPos(): Turtle = {
    if (stack.isEmpty) {
      new Turtle(x, y, heading, pa)
    } else {
      val newStack = stack.tail
      val newPos = stack.head
      new Turtle(newPos.x, newPos.y, newPos.heading, newStack, pa)
    }
  }

}

