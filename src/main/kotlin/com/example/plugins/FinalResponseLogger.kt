package com.example.plugins

import io.ktor.content.*
import io.ktor.server.application.*
import io.ktor.server.application.hooks.*

val FinalResponseLogger = createApplicationPlugin(name = "FinalResponseLogger") {
    on(ResponseBodyReadyForSend) { call, finalResponse ->
        val responseContent = finalResponse as? TextContent
        responseContent?.let { println("Final response: ${responseContent.text}") }
    }
}
