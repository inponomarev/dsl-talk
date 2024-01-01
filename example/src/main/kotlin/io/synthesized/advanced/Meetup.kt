package io.synthesized.advanced

val meetup = brightonKotlin {
    talk("Talk 1") deliveredBy {
        speaker("Speaker 1")
        speaker("Speaker 2")
    }
    talk("Talk 2") deliveredBy {
        speaker("ssd")
        speaker("Speaker 3")
    }
}