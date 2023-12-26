package io.synthesized.dsls

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