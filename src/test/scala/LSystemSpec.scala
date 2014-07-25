package com.rumblesan.lsystem

import org.specs2.mutable._
import org.mockito.Mockito._


class LSystemSpec extends Specification {


  "The LSystem class" should {

    "be created ok with Nil args" in {
      val rules = LSystemRules()
      new LSystem("", rules) must haveClass[LSystem]
    }

    "be fine when created with a simple seed string and basic rules" in {
      val rules = LSystemRules(('A', "B"), ('B', "AB"))
      new LSystem("A", rules) must haveClass[LSystem]
    }

    "correctly process a string of characters using the provided rules" in {
      val rules = LSystemRules(('A', "B"), ('B', "AB"))
      val input = "ABBA"
      val output = "BABABB"
      val ls = new LSystem("", LSystemRules())
      ls.processChars(input, rules) must_== output
    }
    "correctly process a string of characters using the provided rules including for chars without rules" in {
      val rules = LSystemRules(('A', "B"), ('B', "AB"))
      val input = "CABBCA"
      val output = "CBABABCB"
      val ls = new LSystem("", LSystemRules())
      ls.processChars(input, rules) must_== output
    }
    "return a new LSystem object with processed chars when nextGeneration is called" in {
      val rules = LSystemRules(('A', "B"), ('B', "AB"))
      val input = "CABBCA"
      val output = "CBABABCB"
      val ls = new LSystem(input, rules)
      val newLs = ls.nextGeneration()
      newLs.chars must_== output
    }

  }

}



