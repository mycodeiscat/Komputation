package com.komputation.models.export

abstract class ExportBuilder {
    lateinit var file : ExportFormula
    fun CreateFormula()
    {
            file = ExportFormula()
    }
    abstract fun SetHeader()
    abstract fun SetFooter()
    abstract fun SetContent(content : String)
    fun exportFile() : ExportFormula
    {
        return file
    }
}