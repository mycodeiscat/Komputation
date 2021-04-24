package com.komputation.models.export

class XMLexport : ExportBuilder()
{
    override fun SetContent(content: String) {
        file.content=content
    }

    override fun SetFooter() {
        file.footer = "</formula>"
    }

    override fun SetHeader() {
        file.header = "<?xml version='1.0' encoding='UTF-8'?>\n<formula>"
    }

}