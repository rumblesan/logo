package com.rumblesan.lsystem

case class LSystemSubstitution(char: Char, subs: List[Char])

class LSystemRules(charSubs: List[LSystemSubstitution]) {

  val substitutions = charSubs

  def this() = this(Nil)

  def addSub(char: Char, subs: List[Char]):LSystemRules = {
    val newRule = LSystemSubstitution(char, subs)
    new LSystemRules(newRule :: charSubs)
  }

}

class LSystem(seed: List[Char], lRules: List[LSystemSubstitution]) {

  val chars = seed

  val rules = lRules

  def processChars(chars: List[Char], rules: List[LSystemSubstitution]): List[Char] = {

    chars.foldLeft(List.empty[Char])(
      (output, char) => {
        output ::: subChar(char, rules)
      }
    )

  }

  def subChar(c: Char, rules: List[LSystemSubstitution]): List[Char] = {
    val fittingRules = rules.filter(_.char == c)
    if (fittingRules.isEmpty) {
      c :: Nil
    } else {
      fittingRules.head.subs
    }
  }

  def nextGeneration(): LSystem = {
    val nextChars = processChars(chars, rules)
    new LSystem(nextChars, rules)
  }

}

