package com.example.plugins

import com.example.templates.CompanyTemplate
import com.example.templates.CompanyTemplateProvider
import com.example.templates.CompanyTemplateViewModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/index") {
            call.respondHtml(HttpStatusCode.OK) {
                attributes["lang"] = "en"
                head {
                    title { +"Let's tinker with Ktor" }
                    meta { charset = "UTF-8" }
                }
                body {
                    h1 { +"Hello World!" }
                    p { +"Let's tinker with Ktor" }
                }
            }
        }

        get("/index2") {
            val vm = CompanyTemplateViewModel(
                titleText = "Let's tinker with Ktor",
                header = "Welcome to our company",
                bodyContent = "Let's tinker with Ktor",
                footer = "© 2022 Our Company",
                headScripts = listOf("/js/my-company-scripts.js")
            )


            call.respondHtmlTemplate(CompanyTemplateProvider.getTemplate(vm)) {}
        }
    }
}
