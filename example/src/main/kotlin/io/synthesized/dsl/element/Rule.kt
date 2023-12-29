package io.synthesized.dsl.element

class Rule(
    val condition: Condition,
    val transformation: Transformation
) : Element {
    override fun visit(visitor: (Element) -> Unit) {
        condition.visit(visitor)
        transformation.visit(visitor)
        visitor.invoke(this)
    }
}