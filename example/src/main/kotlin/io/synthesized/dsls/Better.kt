package io.synthesized.dsls

/*BETTER EXAMPLE*/
private fun rules(): List<Rule> = listOf(
    Rule(ConditionII, TransformationC),
    Rule(Not(ConditionIV), TransformationB),
    Rule(And(ConditionI, ConditionII), TransformationA),
    Rule(Or(And(ConditionIII, ConditionIV), ConditionI), TransformationB)
)

fun main() {
    rules().firstOrNull { it.condition.met() }?.transformation?.run()
}