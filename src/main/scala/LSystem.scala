package com.rumblesan.lsystem

class LSystemRules(charSubs: Map[Char, String]) {

  val substitutions = charSubs

  def this() = this(Map.empty[Char, String])

  def addSub(char: Char, subs: String):LSystemRules = {
    new LSystemRules(substitutions + (char -> subs))
  }

  def getSub(c: Char): String = {
    substitutions.getOrElse(c, c.toString)
  }

}

class LSystem(seed: String, lRules: LSystemRules) {

  val chars = seed

  val rules = lRules

  def processChars(chars: String, rules: LSystemRules): String = {

    chars.toList.foldLeft("")(
      (output, char) => {
        output + rules.getSub(char)
      }
    )

  }

  def nextGeneration(): LSystem = {
    val nextChars = processChars(chars, rules)
    new LSystem(nextChars, rules)
  }

}

