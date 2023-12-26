package io.synthesized.dsls

val rules: List<Rule> =
    rules {
        ConditionII invokes TransformationC

        not(ConditionIV) invokes TransformationB

        (ConditionI and not(ConditionIII)) invokes TransformationA

        (ConditionIII and ConditionIV or ConditionI) invokes TransformationB
    }
