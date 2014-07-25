package com.rumblesan.lsystem


case class LSystemRules(rules: Map[Char, String])

object LSystemRules {

  def apply(r: (Char, String)*): LSystemRules = {
    LSystemRules(
      r.foldLeft(Map.empty[Char, String])((m, r) => m + r)
    )
  }

  implicit def ToLSystemRulesOps(r: LSystemRules): LSystemRuleOps =
    new LSystemRuleOps {
      def self = r
    }
}

trait LSystemRuleOps {

  def self: LSystemRules

  def apply(c: Char): String = self.rules.getOrElse(c, c.toString)

}


