package io.synthesized.dsl.output

import io.synthesized.dsl.element.And
import io.synthesized.dsl.element.Condition
import io.synthesized.dsl.element.Not
import io.synthesized.dsl.element.Or
import io.synthesized.dsl.element.Rule
import io.synthesized.dsl.element.Transformation

class RuleBuilder {
    val rules = mutableListOf<Rule>()
    infix fun Condition.invokes(generator: Transformation) =
        rules.add(Rule(this, generator))

    infix fun Condition.and(other: Condition): Condition = And(this, other)
    infix fun Condition.or(other: Condition): Condition = Or(this, other)
    fun not(other: Condition) = Not(other)

    fun customCondition(lambda: () -> Boolean): Condition =
        Condition(lambda)

}


fun rules(action: RuleBuilder.() -> Unit): List<Rule> {
    val builder = RuleBuilder()
    builder.action()
    return builder.rules
}


/*
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
*/
