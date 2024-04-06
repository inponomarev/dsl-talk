package io.synthesized.advanced.conferencevar

private val jpoint = javaConference {

    val ip = Speaker("Иван Пономарев", "N/A")

    talk("Пишем приложение на Ktor") deliveredBy {
        + Speaker("Александр Нозик", "МФТИ")
        + Speaker("Глеб Королькевич", "Хоум Банк")
    }

    talk("One source to rule them all: Kotlin DSL как единый источник правды") deliveredBy {
        + ip
    } withExperts {
        + Speaker("Андрей Кулешов", "Huawei")
    }

    talk("Kotlin Script: для кого, зачем и как") deliveredBy {
        + Speaker("Анатолий Нечай-Гумен", "Банк «Центр-инвест»")
    } withExperts {
        + ip
    }

}

