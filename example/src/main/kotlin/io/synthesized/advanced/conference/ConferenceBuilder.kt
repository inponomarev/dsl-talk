package io.synthesized.advanced.conference

data class Talk(
    val name: String,
    val speakers: List<Speaker>,
    val room: Room?
)

data class Room(val name: String)

data class Speaker(val name: String)

//@DslMarker
annotation class ConferenceDsl

@ConferenceDsl
class ConferenceBuilder {
    @ConferenceDsl
    class SpeakersBuilder {
        val speakers = mutableListOf<Speaker>()
        infix fun speaker(name: String) = Speaker(name).also {
            speakers.add(it)
        }

        operator fun String.unaryPlus() = speaker(this)
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
}

fun conference(action: ConferenceBuilder.() -> Unit): List<Talk> {
    val builder = ConferenceBuilder()
    builder.action()
    return builder.talks;
}