package io.synthesized.advanced

data class Talk(val name: String, val speakers: List<Speaker>)
data class Speaker(val name: String)

@DslMarker
annotation class MeetupDsl

@MeetupDsl
class MeetupBuilder {
    @MeetupDsl
    class SpeakersBuilder {
        val speakers = mutableListOf<Speaker>()
        fun speaker(name: String) {
            speakers.add(Speaker(name))
        }
    }

    val talks = mutableListOf<Talk>()

    fun talk(name: String) = Talk(name, listOf())

    infix fun Talk.deliveredBy(action: SpeakersBuilder.() -> Unit) {
        val builder = SpeakersBuilder()
        builder.action()
        talks.add(this.copy(speakers = builder.speakers))
    }
}

fun brightonKotlin(action: MeetupBuilder.() -> Unit): List<Talk> {
    val builder = MeetupBuilder()
    builder.action()
    return builder.talks;
}