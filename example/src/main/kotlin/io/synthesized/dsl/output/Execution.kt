package io.synthesized.dsl.output

fun main() {
    io.synthesized.dsl.rules.firstOrNull { it.condition.met() }?.transformation?.run()
}