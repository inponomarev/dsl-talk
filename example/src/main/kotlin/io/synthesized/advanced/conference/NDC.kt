import io.synthesized.advanced.conference.conference

val ndcCopenhagen = conference {
    session("One Source to Rule Them All: Kotlin DSLs") deliveredBy {
        speaker("Ivan Ponomarev")
    } inRoom ("Room 3")

    session("Edge-native applications - what happened to cloud-native?") deliveredBy {
        speaker("Mikkel Mørk Hegnhøj")
        speaker("Thorsten Hans")
    } inRoom ("Room 3")

    session(
        "Part 1/2: Introduction to capture the flag (CTF)"
    ) deliveredBy {
        speaker("Mark Jervelund")
    } inRoom ("Room 4")

    session(
        "Part 1/2: Introduction to capture the flag (CTF)"
    ) deliveredBy {
        speaker("Mark Jervelund")
    } inRoom ("Room 4")
}