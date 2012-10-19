package com.rumblesan.lsystem

import org.specs2.mutable._
import org.mockito.Mockito._

class LSystemRulesSpec extends Specification {

  "The LSystemRules class" should {

    "be created fine with the empty constructor" in {
      new LSystemRules() must haveClass[LSystemRules]
    }
    "be created fine with the list constructor" in {
      new LSystemRules(Nil) must haveClass[LSystemRules]
    }

    "return a new object when the addSub method is called" in {
      val lsr = new LSystemRules()
      val newLsr = lsr.addSub('A', "B".toList)
      newLsr must haveClass[LSystemRules]
    }

    "return a new object with the added sub when the addSub method is called" in {
      val lsr = new LSystemRules()
      val newLsr = lsr.addSub('A', "B".toList)
      val lSub = LSystemSubstitution('A', "B".toList)
      newLsr.substitutions.head must_== lSub
    }




  }


}

