package io.synthesized.advanced.conference

private val jpoint = javaConference {

    talk("Пишем приложение на Ktor") deliveredBy {

        speaker("Александр Нозик")
        speaker("Глеб Королькевич")
    }

    talk("One source to rule them all: Kotlin DSL как единый источник правды") deliveredBy {
        speaker("Иван Пономарев")
    } withExperts {
        speaker("Андрей Кулешов")
    }

    talk("Kotlin Script: для кого, зачем и как") deliveredBy {
        speaker("Анатолий Нечай-Гумен")
    } withExperts {
        speaker("Иван Пономарев")
    }

}