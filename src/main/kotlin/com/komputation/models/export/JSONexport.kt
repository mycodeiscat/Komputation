package com.komputation.models.export

class JSONexport: ExportBuilder() {
    override fun SetHeader() {
        file.header="{"
    }

    override fun SetContent(content: String) {
        file.content="\"formula\" : \"$content\""
    }

    override fun SetFooter() {
        file.footer = "}"
    }
}