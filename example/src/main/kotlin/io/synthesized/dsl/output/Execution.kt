package io.synthesized.dsl.output

import io.synthesized.dsl.rules

fun main() {
    rules.firstOrNull { it.condition.met() }?.transformation?.run()
}