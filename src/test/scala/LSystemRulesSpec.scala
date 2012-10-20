package com.rumblesan.lsystem

import org.specs2.mutable._
import org.mockito.Mockito._

class LSystemRulesSpec extends Specification {

  "The LSystemRules class" should {

    "be created fine with the empty constructor" in {
      new LSystemRules() must haveClass[LSystemRules]
    }
    "be created fine with the list constructor" in {
      new LSystemRules(Map.empty[Char, String]) must haveClass[LSystemRules]
    }

    "return a new object when the addSub method is called" in {
      val lsr = new LSystemRules()
      val newLsr = lsr.addSub('A', "B")
      newLsr must haveClass[LSystemRules]
    }

    "return a new object with the added sub when the addSub method is called" in {
      val lsr = new LSystemRules()
      val newLsr = lsr.addSub('A', "B")
      val lSub = Map('A' -> "B")
      newLsr.substitutions must_== lSub
    }

    "return a String from getSub method with the transformed chars when it has a corresponding substitution rule" in {
      val rules = new LSystemRules().addSub('A', "B")
      rules.getSub('A') must_== "B"
    }
    "return a String from getSub method with the unchanged char when it has does not have a corresponding substitution rule" in {
      val rules = new LSystemRules().addSub('B', "B")
      rules.getSub('A') must_== "A"
    }
    "return a String from getSub method with the unchanged char when it has no substitution rules" in {
      val rules = new LSystemRules()
      rules.getSub('A') must_== "A"
    }
  }


}

