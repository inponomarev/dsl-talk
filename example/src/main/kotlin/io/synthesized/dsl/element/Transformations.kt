package io.synthesized.dsl.element

import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "type",
)
sealed interface Transformation: Element {
    fun run()
}

object TransformationA : Transformation {
    override fun run() {
        println("Transformation A invoked")
    }
}

object TransformationB : Transformation {
    override fun run() {
        println("Transformation B invoked")
    }
}

object TransformationC : Transformation {
    override fun run() {
        println("Transformation C invoked")
    }
}