package io.synthesized.dsls

import java.io.PrintWriter
import java.io.StringWriter

fun Rule.describe(): String {
    val d = ArrayDeque<String>()
    condition.visit {
        when (it) {
            is Not -> d.addLast("!(${d.removeLast()})")
            is And -> {
                val b = d.removeLast();
                val a = d.removeLast()
                d.addLast("($a && $b)")
            }

            is Or -> {
                val b = d.removeLast();
                val a = d.removeLast()
                d.addLast("($a || $b)")
            }

            else -> d.addLast("${it::class.simpleName}")
        }
    }
    return d.removeLast()
}

fun main() {
    val rulesMap = rules.groupBy { it.transformation::class.simpleName }
    val sw = StringWriter()
    val pw = PrintWriter(sw)
    for ((transformation, rules) in rulesMap) {
        pw.println("== $transformation")
        pw.println()
        pw.println("Activated by")
        pw.println()
        for (rule in rules) {
            pw.println("* `${rule.describe()}`")
        }
        pw.println()
    }
    println(sw)
}