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
    } else if ((conditionThreeMet() || conditionFourMet()) && conditionOneMet()) {
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
private fun conditionOneMet() = ConditionI.met()
private fun conditionTwoMet() = ConditionII.met()
private fun conditionThreeMet() = ConditionIII.met()
private fun conditionFourMet() = ConditionIII.met()