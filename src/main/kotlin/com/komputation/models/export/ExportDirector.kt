package com.komputation.models.export

class ExportDirector {
    fun exportFile(builder: ExportBuilder, content: String) : ExportFormula {
        builder.CreateFormula()
        builder.SetHeader()
        builder.SetContent(content)
        builder.SetFooter()
        return builder.exportFile()
    }
}