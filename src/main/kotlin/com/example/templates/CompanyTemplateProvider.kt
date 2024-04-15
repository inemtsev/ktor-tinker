package com.example.templates

import kotlinx.html.h1
import kotlinx.html.p
import kotlinx.html.script

data class CompanyTemplateViewModel(
    val titleText: String,
    val header: String,
    val bodyContent: String,
    val footer: String,
    val headScripts: List<String>
)

object CompanyTemplateProvider {
    fun getTemplate(viewModel: CompanyTemplateViewModel): CompanyTemplate {
        val template =
            CompanyTemplate().apply {
                titleText { +viewModel.titleText }
                headScripts {
                    for (script in viewModel.headScripts)
                        script(src = script) {}
                }
                header {
                    h1 { +viewModel.header }
                }
                bodyContent {
                    p { +viewModel.bodyContent }
                }
                footer {
                    p { +viewModel.footer }
                }
            }

        return template
    }
}
