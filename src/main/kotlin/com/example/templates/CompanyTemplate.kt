package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class CompanyTemplate : Template<HTML> {
    val titleText = Placeholder<TITLE>()
    val headScripts = Placeholder<HEAD>()
    val bodyContent = Placeholder<BODY>()
    val header = Placeholder<BODY>()
    val footer = Placeholder<BODY>()

    override fun HTML.apply() {
        attributes["lang"] = "en"
        head {
            link { rel = "stylesheet"; type = "text/css"; href = "/css/my-company-styles.css" }
            title { insert(titleText) }
            meta { charset = "UTF-8" }
            insert(headScripts)
        }
        body {
            insert(header)
            insert(bodyContent)
            insert(footer)
        }
    }
}
