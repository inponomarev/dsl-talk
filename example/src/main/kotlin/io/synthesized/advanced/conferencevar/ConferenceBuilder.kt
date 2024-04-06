package io.synthesized.advanced.conferencevar

data class Talk(val name: String, val speakers: List<Speaker>, val experts: List<Speaker>)
data class Speaker(val name: String, val company: String)

@DslMarker
annotation class ConferenceDsl

@ConferenceDsl
class ConferenceBuilder {
    @ConferenceDsl
    class SpeakersBuilder {
        val speakers = mutableListOf<Speaker>()
        operator fun Speaker.unaryPlus() = speaker(this)
        private fun speaker(speaker: Speaker) =
            speaker.also { speakers.add(it) }

    }

    val talks = mutableListOf<Talk>()

    infix fun talk(name: String): Talk {
        val result = Talk(name, listOf(), listOf())
        talks.add(result)
        return result
    }

    infix fun Talk.deliveredBy(action: SpeakersBuilder.() -> Unit): Talk {
        val builder = SpeakersBuilder()
        builder.action()
        val newTalk = this.copy(speakers = builder.speakers)
        talks.remove(this)
        talks.add(newTalk)
        return newTalk
    }

    infix fun Talk.withExperts(action: SpeakersBuilder.() -> Unit): Talk {
        val builder = SpeakersBuilder()
        builder.action()
        val newTalk = this.copy(experts = builder.speakers)
        talks.remove(this)
        talks.add(newTalk)
        return newTalk
    }
}

fun javaConference(action: ConferenceBuilder.() -> Unit): List<Talk> {
    val builder = ConferenceBuilder()
    builder.action()
    return builder.talks;
}