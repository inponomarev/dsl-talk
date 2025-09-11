package io.synthesized.advanced.conferenceinvoke

val talks = run {
    conference.name = "NDC Copenhagen"
    conference {
        //val ip = Speaker("ip", "Ivan Ponomarev", "Synthesized")
        val ip by speaker("Ivan Ponomarev", "Synthesized")
        val mj by speaker("Mark Jervelund", "Microsoft")
        val mmh by speaker("Mikkel Mørk Hegnhøj", "Fermyon")
        val th by speaker("Thorsten Hans", "Fermyon")
        session("One Source to Rule Them All: Kotlin DSLs") deliveredBy {
            +ip
        } inRoom "Room 6"

        session("Edge-native applications - what happened to cloud-native?") deliveredBy {
            +mmh
            +th
        } inRoom "Room 3"


        session("Part 1/2: Introduction to capture the flag (CTF)") deliveredBy {
            +mj
        } inRoom ("Room 4")

        session("Part 2/2: Introduction to capture the flag (CTF)") deliveredBy {
            +mj
        } inRoom ("Room 4")
    }
}
