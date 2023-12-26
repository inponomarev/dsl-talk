package io.synthesized.dsls

/* BAD EXAMPLE */
fun main() {
    if (conditionOneMet() && conditionTwoMet()) {
        TransformationA.run()
    } else if ((ConditionIII.met() || ConditionIV.met()) && conditionOneMet()) {
        TransformationB.run()
    } else if (conditionTwoMet()) {
        TransformationC.run()
    }
}










private fun conditionTwoMet() = ConditionII.met()

private fun conditionOneMet() = ConditionI.met()
