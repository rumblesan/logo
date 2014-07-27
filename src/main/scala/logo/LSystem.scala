package com.rumblesan.lsystem


case class LSystem(chars: Vector[Char], rules: LSystemRules)

object LSystem {

  def apply(chars: String, rules: LSystemRules): LSystem = LSystem(chars.toVector, rules)

  implicit def ToLSystemOps(l: LSystem): LSystemOps =
    new LSystemOps {
      def self = l
    }

  def processChars(chars: Vector[Char], rules: LSystemRules): Vector[Char] = {
    chars.foldLeft(Vector.empty[Char])(
      (output, char) => {
        output ++ rules(char)
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

