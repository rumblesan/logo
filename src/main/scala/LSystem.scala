package com.rumblesan.lsystem


class LSystem(seed: String, lRules: LSystemRules) {

  val chars = seed

  val rules = lRules

  def processChars(chars: String, rules: LSystemRules): String = {

    chars.toList.foldLeft("")(
      (output, char) => {
        output + rules(char)
      }
    )

  }

  def nextGeneration(): LSystem = {
    val nextChars = processChars(chars, rules)
    new LSystem(nextChars, rules)
  }

}

