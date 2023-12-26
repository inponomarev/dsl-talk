package io.synthesized.dsls

import kotlin.random.Random

sealed interface Condition: Element {
    fun met(): Boolean
}






//////////////////////////////////////////
sealed interface BasicCondition: Condition

object ConditionI : BasicCondition {
    private val status = Random.nextBoolean()
    override fun met(): Boolean = status
}

object ConditionII : BasicCondition {
    private val status = Random.nextBoolean()
    override fun met(): Boolean = status
}

object ConditionIII : BasicCondition {
    private val status = Random.nextBoolean()
    override fun met(): Boolean = status
}

object ConditionIV : BasicCondition {
    private val status = Random.nextBoolean()
    override fun met(): Boolean = status
}

//////////////////////////////////////////
abstract class BinaryCondition(val a: Condition, val b: Condition) : Condition {
    override fun visit(visitor: (Element) -> Unit) {
        a.visit(visitor)
        b.visit(visitor)
        visitor.invoke(this)
    }
}

class Or(a: Condition, b: Condition) : BinaryCondition(a, b) {
    override fun met(): Boolean {
        return a.met() || b.met();
    }
}

class And(a: Condition, b: Condition) : BinaryCondition(a, b) {
    override fun met(): Boolean {
        return a.met() && b.met();
    }
}

class Not(val a: Condition) : Condition {
    override fun met(): Boolean {
        return !a.met();
    }

    override fun visit(visitor: (Element) -> Unit) {
        a.visit(visitor)
        visitor.invoke(this)
    }
}