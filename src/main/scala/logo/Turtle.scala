package com.rumblesan.logo.turtle

import processing.core._

import scala.math._

case class StackInfo(x: Double, y: Double, heading: Double)


case class Turtle(x: Double, y: Double, heading: Double, stack: List[StackInfo], p: PApplet)


object Turtle {

  implicit def double2Float(v: Double) = v.toFloat

  def deg2Rad(degree: Double): Double = {
    ((degree * 2 * Pi) / 360)
  }


  implicit def ToTurtleOps(t: Turtle): TurtleOps =
    new TurtleOps {
      def self = t
    }


}

trait TurtleOps {

  import Turtle._

  def self: Turtle

  def move(distance: Double): Turtle = {
    val xDelta = sin(deg2Rad(self.heading)) * distance
    val yDelta = cos(deg2Rad(self.heading)) * distance

    val x2 = self.x + xDelta
    val y2 = self.y + yDelta

    self.p.line(self.x, self.y, x2, y2)

    Turtle(x2, y2, self.heading, self.stack, self.p)
  }

  def turn(angle: Double): Turtle = self.copy(heading = self.heading + angle)

  def pushPos(): Turtle = {
    val newStack = StackInfo(self.x, self.y, self.heading) :: self.stack
    self.copy(stack = newStack)
  }

  def popPos(): Turtle = {
    if (self.stack.isEmpty) {
      self
    } else {
      val newStack = self.stack.tail
      val newPos = self.stack.head
      Turtle(newPos.x, newPos.y, newPos.heading, newStack, self.p)
    }
  }

}

