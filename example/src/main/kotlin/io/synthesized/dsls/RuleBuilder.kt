package io.synthesized.dsls

class RuleBuilder {
    val rules = mutableListOf<Rule>()

    infix fun Condition.and(other: Condition): Condition = And(this, other)
    infix fun Condition.or(other: Condition): Condition = Or(this, other)
    fun not(other: Condition) = Not(other)

    infix fun Condition.invokes(generator: Transformation) = rules.add(Rule(this, generator))
}

fun rules(action: RuleBuilder.() -> Unit): List<Rule> {
    val builder = RuleBuilder()
    builder.action()
    return builder.rules
}

