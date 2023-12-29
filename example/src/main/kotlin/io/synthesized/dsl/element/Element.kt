package io.synthesized.dsl.element

interface Element {
    fun visit(visitor: (Element) -> Unit) {
        visitor.invoke(this)
    }
}