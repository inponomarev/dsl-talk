package io.synthesized.dsl

import io.synthesized.dsl.element.And
import io.synthesized.dsl.element.BasicCondition
import io.synthesized.dsl.element.Condition
import io.synthesized.dsl.element.Not
import io.synthesized.dsl.element.Or
import io.synthesized.dsl.element.Rule
import io.synthesized.dsl.output.describe
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.test.fail

typealias ConditionClass = KClass<out BasicCondition>

class SanityTest {
    @Test
    fun `no rules are unreachable`() {
        val reachableRules = mutableSetOf<Rule>()
        outcomes().forEach { outcome ->
            println("testing outcome: ${outcome.map { it.simpleName }}")
            rules.firstOrNull {
                calculate(it.condition, outcome)
            }?.let {
                reachableRules.add(it)
                println("  rule reached: ${it.describe()}")
            }
        }
        val unreachableRules = rules.toSet().minus(reachableRules)
        if (unreachableRules.isNotEmpty()) {
            fail("The following rules are unreachable: ${unreachableRules.map { it.describe() }}")
        }
    }

    private val conditions = BasicCondition::class.sealedSubclasses

    fun outcomes(): Sequence<Set<ConditionClass>> = sequence {
        for (i in 0L until (1L shl conditions.size)) {
            val activeConditions = mutableSetOf<ConditionClass>()
            for (j in 0 until conditions.size) {
                if ((i and (1L shl j)) != 0L) {
                    activeConditions.add(conditions[j])
                }
            }
            yield(activeConditions)
        }
    }

    fun calculate(condition: Condition, activeConditions: Set<ConditionClass>): Boolean {
        val d = ArrayDeque<Boolean>()
        condition.visit {
            when (it) {
                is Not -> d.addLast(!d.removeLast())
                is And -> d.addLast(d.removeLast() && d.removeLast())
                is Or -> d.addLast(d.removeLast() || d.removeLast())
                else -> d.addLast(it::class in activeConditions)
            }
        }
        return d.removeLast()
    }

}