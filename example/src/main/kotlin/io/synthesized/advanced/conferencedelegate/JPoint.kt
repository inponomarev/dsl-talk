package io.synthesized.advanced.conferencedelegate

private val jpoint = javaConference {

    val ip by speaker("Иван Пономарев", "N/A")
    val an by speaker("Александр Нозик", "МФТИ")
    val gk by speaker("Глеб Королькевич", "Хоум Банк")

    talk("Пишем приложение на Ktor") deliveredBy {
        +an
        +gk
    }

    talk("One source to rule them all: Kotlin DSL как единый источник правды") deliveredBy {
        +ip
    } withExperts {
        +Speaker("ak", "Андрей Кулешов", "Huawei")
    }

    talk("Kotlin Script: для кого, зачем и как") deliveredBy {
        +Speaker("ang", "Анатолий Нечай-Гумен", "Банк «Центр-инвест»")
    } withExperts {
        +ip
    }

}

fun main() {
    println(jpoint)
}

