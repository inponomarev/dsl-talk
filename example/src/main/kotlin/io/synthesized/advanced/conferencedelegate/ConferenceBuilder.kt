package io.synthesized.advanced.conferencedelegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

data class Talk(
    val name: String,
    val speakers: List<Speaker>,
    val room: Room?
)

data class Room(val name: String)

data class Speaker(val id: String, val name: String, val company: String)

@DslMarker
annotation class ConferenceDsl

@ConferenceDsl
class ConferenceBuilder {
    @ConferenceDsl
    class SpeakersBuilder {
        val speakers = mutableListOf<Speaker>()
        fun speaker(speaker: Speaker) = speaker.also {
            speakers.add(it)
        }

        operator fun Speaker.unaryPlus() = speaker(this)
    }

    val talks = mutableListOf<Talk>()

    infix fun session(name: String): Talk {
        val result = Talk(name, listOf(), null)
        talks.add(result)
        return result
    }

    operator fun String.unaryPlus() = session(this)
    infix fun Talk.deliveredBy(action: SpeakersBuilder.() -> Unit): Talk {
        val builder = SpeakersBuilder()
        builder.action()
        val newTalk = this.copy(speakers = builder.speakers)
        talks.remove(this)
        talks.add(newTalk)
        return newTalk
    }

    infix fun Talk.inRoom(roomNumber: String): Talk {
        val newTalk = this.copy(room = Room(roomNumber))
        talks.remove(this)
        talks.add(newTalk)
        return newTalk
    }

    val speakers = mutableMapOf<String, Speaker>()
    fun speaker(name: String, company: String): ReadOnlyProperty<Any?, Speaker> =
        ReadOnlyProperty { _, property: KProperty<*> ->
            speakers.computeIfAbsent(property.name) { Speaker(it, name, company) }
        }

}

fun conference(action: ConferenceBuilder.() -> Unit): List<Talk> {
    val builder = ConferenceBuilder()
    builder.action()
    return builder.talks;
}