package io.synthesized.dsls

fun main() {
    rules.firstOrNull { it.condition.met() }?.transformation?.run()
}