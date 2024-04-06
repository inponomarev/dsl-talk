package io.synthesized.dsl

import io.synthesized.dsl.element.ConditionI
import io.synthesized.dsl.element.ConditionII
import io.synthesized.dsl.element.ConditionIII
import io.synthesized.dsl.element.ConditionIV
import io.synthesized.dsl.element.Rule
import io.synthesized.dsl.element.TransformationA
import io.synthesized.dsl.element.TransformationB
import io.synthesized.dsl.element.TransformationC
import io.synthesized.dsl.output.rules

val rules: List<Rule> =
    // @formatter:off
    rules {
        ConditionI and ConditionIV         invokes TransformationA
        ConditionII                        invokes TransformationC
        not(ConditionIV)                   invokes TransformationB
        (ConditionI and not(ConditionIII)) invokes TransformationA
        (ConditionIII
                and ConditionIV
                or ConditionI)             invokes TransformationB
    }
   // @formatter:on