package com.rumblesan.lsystem

case class LSystemSubstitution(input: Char, subs: List[Char])

class LSystem(input: List[Char], lRules: List[LSystemSubstitution]) {

  val chars = input

  val rules = lRules

  def processChars(chars: List[Char], rules: List[LSystemSubstitution]): List[Char] = {

    chars.foldLeft(List.empty[Char])(
      (output, char) => {
        output ::: subChar(char, rules)
      }
    )

  }

  def subChar(c: Char, rules: List[LSystemSubstitution]): List[Char] = {
    val fittingRules = rules.filter(_.input == c)
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

