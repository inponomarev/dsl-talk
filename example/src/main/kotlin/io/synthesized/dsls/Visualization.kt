package io.synthesized.dsls

import java.awt.Desktop
import java.io.PrintWriter
import java.io.StringWriter
import java.net.URI
import java.net.URLEncoder

fun main() {
    val visited = mutableMapOf<Element, String>()
    val transformations = mutableListOf<Transformation>()
    val conditions = mutableListOf<Condition>()
    var counter = 1
    val sw = StringWriter()
    val pw = PrintWriter(sw)
    pw.println("digraph G {")

    fun visitor(element: Element) {
        if (visited.putIfAbsent(element, "N${counter++}") == null) {
            when (element) {
                is Transformation -> {
                    pw.println("  ${visited[element]}[label=\"${element::class.simpleName}\",shape=\"box\",style=\"rounded\"];")
                    transformations.add(element)
                }

                is BasicCondition -> {
                    pw.println("  ${visited[element]}[label=\"${element::class.simpleName}\",shape=\"box\",style=\"rounded\"];")
                    conditions.add(element)
                }

                is Rule -> {
                    pw.println("  ${visited[element.condition]}->${visited[element.transformation]};")
                }

                is BinaryCondition -> {
                    pw.println("  ${visited[element]}[label=\"${element::class.simpleName}\"];");
                    pw.println("  ${visited[element.a]}->${visited[element]};")
                    pw.println("  ${visited[element.b]}->${visited[element]};")
                }

                is Not -> {
                    pw.println("  ${visited[element]}[label=\"${element::class.simpleName}\"];")
                    pw.println("  ${visited[element.a]}->${visited[element]};")
                }
            }
        }
    }

    for (rule in rules) {
        rule.visit(::visitor)
    }
    pw.println("  {rank=\"same\";${transformations.map(visited::get).joinToString(";")};}")
    pw.println("  {rank=\"same\";${conditions.map(visited::get).joinToString(";")};}")
    pw.println("}")

    show(sw.toString())
}

private fun show(dot: String) {
    val encoded = URLEncoder.encode(dot, "UTF8")
        .replace("\\+".toRegex(), "%20")
    Desktop.getDesktop().browse(URI("https://dreampuf.github.io/GraphvizOnline/#$encoded"))
}