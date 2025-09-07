package io.synthesized.advanced.conferencevar

val ndcCopenhagen = conference {
    val mj = Speaker("Mark Jervelund", "Microsoft")

    session("One Source to Rule Them All: Kotlin DSLs") deliveredBy {
        +Speaker("Ivan Ponomarev", "Synthesized")
    } inRoom "Room 6"


    session("Edge-native applications - what happened to cloud-native?") deliveredBy {
        +Speaker("Mikkel Mørk Hegnhøj", "Fermyon")
        +Speaker("Thorsten Hans", "Fermyon")
    } inRoom ("Room 3")


    session("Part 1/2: Introduction to capture the flag (CTF)") deliveredBy {
        +mj
    } inRoom ("Room 4")

    session("Part 2/2: Introduction to capture the flag (CTF)") deliveredBy {
        +mj
    } inRoom ("Room 4")

}