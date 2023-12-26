package io.synthesized.dsls

interface Element {
    fun visit(visitor: (Element) -> Unit) {
        visitor.invoke(this)
    }
}