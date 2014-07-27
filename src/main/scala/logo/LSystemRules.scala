package com.rumblesan.lsystem


case class LSystemRules(rules: Map[Char, Vector[Char]])

object LSystemRules {

  def rulePairTransform(p: (Char, String)): (Char, Vector[Char]) = (p._1, p._2.toVector)

  def apply(r: (Char, String)*): LSystemRules = {
    LSystemRules(
      r.foldLeft(Map.empty[Char, Vector[Char]])((m, r) => m + rulePairTransform(r))
    )
  }

  implicit def ToLSystemRulesOps(r: LSystemRules): LSystemRuleOps =
    new LSystemRuleOps {
      def self = r
    }
}

trait LSystemRuleOps {

  def self: LSystemRules

  def apply(c: Char): Vector[Char] = self.rules.getOrElse(c, Vector(c))

}


