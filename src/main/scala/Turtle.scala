package com.rumblesan.logo.turtle

import processing.core._

import scala.math._

object Turtle {

  implicit def double2Float(v: Double) = v.toFloat

}

case class StackInfo(x: Double, y: Double, z: Double, pitch: Double, yaw: Double)

class Turtle(xVal: Double, yVal: Double, zVal: Double, pi: Double, ya: Double, stateStack: List[StackInfo], pApplet: PApplet) {

  import Turtle._

  def this(xVal: Double, yVal: Double, zVal: Double, pi: Double, ya: Double, pApplet: PApplet) = {
    this(xVal, yVal, zVal, pi, ya, Nil, pApplet)
  }

  def this(xVal: Double, yVal: Double, zVal: Double, pApplet: PApplet) = {
    this(xVal, yVal, zVal, 0.0, 0.0, Nil, pApplet)
  }

  val x = xVal
  val y = yVal
  val z = zVal

  val stack = stateStack

  val pitch = pi
  val yaw = ya

  val pa = pApplet

  def deg2Rad(degree: Double): Double = {
    ((degree * 2 * Pi) / 360)
  }

  def move(distance: Double): Turtle = {
    val zDelta = sin(deg2Rad(pitch)) * distance
    val inter = cos(deg2Rad(pitch)) * distance
 
    val xDelta = sin(deg2Rad(yaw)) * inter
    val yDelta = cos(deg2Rad(yaw)) * inter

    val x2 = x + xDelta
    val y2 = y + yDelta
    val z2 = z + zDelta

    pa.line(x, y, z, x2, y2, z2)

    new Turtle(x2, y2, z2, pitch, yaw, stack, pa)
  }

  def pitch(angle: Double): Turtle = {
    new Turtle(x, y, z, pitch + angle, yaw, stack, pa)
  }

  def yaw(angle: Double): Turtle = {
    new Turtle(x, y, z, pitch, yaw + angle, stack, pa)
  }

  def pushPos(): Turtle = {
    val newStack = StackInfo(x, y, z, pitch, yaw) :: stack
    new Turtle(x, y, z, pitch, yaw, newStack, pa)
  }

  def popPos(): Turtle = {
    if (stack.isEmpty) {
      new Turtle(x, y, z, pitch, yaw, pa)
    } else {
      val newStack = stack.tail
      val newPos = stack.head
      new Turtle(newPos.x, newPos.y, newPos.z, newPos.pitch, newPos.yaw, newStack, pa)
    }
  }

}

