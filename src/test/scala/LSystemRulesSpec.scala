package com.rumblesan.lsystem

import org.specs2.mutable._


class LSystemRulesSpec extends Specification {

  "The LSystemRules class" should {

    "be created fine with the list constructor" in {
      LSystemRules(('a', "aaa"), ('b', "bbb")) must_==(
        LSystemRules(
          Map('a' -> "aaa", 'b' -> "bbb")
        )
      )
    }

    "return a String from getSub method with the transformed chars when it has a corresponding substitution rule" in {
      val rules = LSystemRules(('A', "B"))
      rules('A') must_== "B"
    }
    "return a String from getSub method with the unchanged char when it has does not have a corresponding substitution rule" in {
      val rules = LSystemRules(('B', "B"))
      rules('A') must_== "A"
    }
    "return a String from getSub method with the unchanged char when it has no substitution rules" in {
      val rules = LSystemRules()
      rules('A') must_== "A"
    }
  }


}

