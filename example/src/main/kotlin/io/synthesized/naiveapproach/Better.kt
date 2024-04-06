package io.synthesized.naiveapproach

import io.synthesized.dsl.element.And
import io.synthesized.dsl.element.ConditionI
import io.synthesized.dsl.element.ConditionII
import io.synthesized.dsl.element.ConditionIII
import io.synthesized.dsl.element.ConditionIV
import io.synthesized.dsl.element.Not
import io.synthesized.dsl.element.Or
import io.synthesized.dsl.element.Rule
import io.synthesized.dsl.element.TransformationA
import io.synthesized.dsl.element.TransformationB
import io.synthesized.dsl.element.TransformationC

/*BETTER EXAMPLE*/
private fun rules(): List<Rule> = listOf(
    Rule(ConditionII, TransformationC),
    Rule(Not(ConditionIV), TransformationB),
    Rule(And(ConditionI, ConditionII), TransformationA),
    Rule(Or(And(ConditionIII, ConditionIV), ConditionI), TransformationB)
)


fun main() {
    rules()
        .firstOrNull { it.condition.met() }
        ?.transformation?.run()
}