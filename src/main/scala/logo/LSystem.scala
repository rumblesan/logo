package com.rumblesan.lsystem


case class LSystem(chars: String, rules: LSystemRules)

object LSystem {

  implicit def ToLSystemOps(l: LSystem): LSystemOps =
    new LSystemOps {
      def self = l
    }

  def processChars(chars: String, rules: LSystemRules): String = {
    chars.toList.foldLeft("")(
      (output, char) => {
        output + rules(char)
      }
    )
  }

}


trait LSystemOps {

  def self: LSystem

  def nextGeneration(): LSystem = {
    self.copy(chars = LSystem.processChars(self.chars, self.rules))
  }

}

