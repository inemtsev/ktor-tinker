package com.example.plugins

import io.ktor.server.application.*
import io.ktor.util.*

val MeasureTimeToResponse = createApplicationPlugin(name = "MeasureTransformationBenchmarkPlugin") {
    val timeToResponseKey = AttributeKey<Long>("timeToResponseKey")

    onCall { call ->
        val callTime = System.currentTimeMillis()
        call.attributes.put(timeToResponseKey, callTime)
    }

    onCallRespond { call ->
        val callTime = call.attributes[timeToResponseKey]
        val responseTime = System.currentTimeMillis()

        println("Time to response: ${responseTime - callTime} ms")
    }
}
