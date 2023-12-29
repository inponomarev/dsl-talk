package io.synthesized.dsl.output

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

fun main() {
    val om = ObjectMapper(
        YAMLFactory.builder()
            .disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID)
            .build()
    )
        .apply {
            propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
            registerModule(
                KotlinModule.Builder()
                    .configure(KotlinFeature.SingletonSupport, true)
                    .build()
            )
        }
    println(om.writeValueAsString(io.synthesized.dsl.rules))
}