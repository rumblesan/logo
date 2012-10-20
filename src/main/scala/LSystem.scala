package com.rumblesan.lsystem

case class LSystemSubstitution(char: Char, subs: String)

class LSystemRules(charSubs: List[LSystemSubstitution]) {

  val substitutions = charSubs

  val lookup = {
    charSubs.foldLeft(Map.empty[Char, String])(
      (map, rule) => {
        map + (rule.char -> rule.subs.toString)
      }
    )
  }

  def this() = this(Nil)

  def addSub(char: Char, subs: String):LSystemRules = {
    val newRule = LSystemSubstitution(char, subs)
    new LSystemRules(newRule :: charSubs)
  }

}

class LSystem(seed: String, lRules: LSystemRules) {

  val chars = seed

  val rules = lRules

  def processChars(chars: String, rules: LSystemRules): String = {

    chars.toList.foldLeft("")(
      (output, char) => {
        output + subChar(char, rules)
      }
    )

  }

  def subChar(c: Char, rules: LSystemRules): String = {
    rules.lookup.getOrElse(c, c.toString)
  }

  def nextGeneration(): LSystem = {
    val nextChars = processChars(chars, rules)
    new LSystem(nextChars, rules)
  }

}

