package io.synthesized.naiveapproach

import io.synthesized.dsl.element.ConditionI
import io.synthesized.dsl.element.ConditionII
import io.synthesized.dsl.element.ConditionIII
import io.synthesized.dsl.element.ConditionIV
import io.synthesized.dsl.element.TransformationA
import io.synthesized.dsl.element.TransformationB
import io.synthesized.dsl.element.TransformationC

/* BAD EXAMPLE */
fun main() {
    if (conditionOneMet() && conditionTwoMet()) {
        runTransformationA()
    } else if ((ConditionIII.met() || ConditionIV.met()) && conditionOneMet()) {
        runTransformationB()
    } else if (conditionTwoMet()) {
        runTransformationC()
    } else {
        runTransformationB()
    }
}




















private fun runTransformationC() = TransformationC.run()
private fun runTransformationB() = TransformationB.run()
private fun runTransformationA() = TransformationA.run()
private fun conditionTwoMet() = ConditionII.met()
private fun conditionOneMet() = ConditionI.met()
