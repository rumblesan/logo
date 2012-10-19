package com.rumblesan.penrose

import org.specs2.mutable._
import org.mockito.Mockito._

import processing.core.PApplet
import scala.math.Pi
import com.rumblesan.logo.turtle.Turtle

class TurtleSpec extends Specification {

  def createNewTurtle(): Turtle = {
    val pa = mock(classOf[PApplet])
    new Turtle(0.0f, 0.0f, 0.0f, pa)
  }

  "The Turtle class" should {

    "be created ok" in {
      createNewTurtle() must haveClass[Turtle]
    }
    "convert degrees to radians correctly" in {
      val t = createNewTurtle()
      t.deg2Rad(90.0f) must_== (Pi/2).toFloat
    }

    "return a new Turtle instance when it's moved" in {
      val t = createNewTurtle()
      val newT = t.move(10.0f)
      newT must haveClass[Turtle]
    }
    "update the position of the new Turtle instance" in {
      val t = createNewTurtle()
      val newT = t.move(10.0f)
      newT.y must_== 10.0f
    }

    "return a new Turtle instance when it's turned" in {
      val t = createNewTurtle()
      val newT = t.turn(10.0f)
      newT must haveClass[Turtle]
    }
    "update the heading of the new Turtle instance" in {
      val t = createNewTurtle()
      val newT = t.turn(10.0f)
      val newHeading = t.deg2Rad(10.0f)
      newT.heading must_== newHeading
    }

  }
}
