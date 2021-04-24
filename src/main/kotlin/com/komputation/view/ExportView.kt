package com.komputation.view

import com.komputation.models.export.ExportDirector
import com.komputation.models.export.JSONexport
import com.komputation.models.export.XMLexport
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class ExportController : Controller() {
    var result : String = ""
    fun load(input: String) : List<String>
    {
        if(result.isEmpty()) result  = input
        val builder = ExportDirector()
        val xml_file = builder.exportFile(XMLexport(), result)
        val json_file = builder.exportFile(JSONexport(), result)

        return listOf("${xml_file.header}\n${xml_file.content}\n${xml_file.footer}", "${json_file.header}\n${json_file.content}\n${json_file.footer}")
    }
}

class ExportView : Fragment("Export") {
    val input: String by param()
    val controller: ExportController by inject()
    var xml : SimpleStringProperty = SimpleStringProperty(controller.load("")[0])
    var json : SimpleStringProperty = SimpleStringProperty(controller.load("")[1])
    override val root = vbox{
        label("XML")
        textarea("Xml")
        {
            bind(xml)
        }
        label("JSON")
        textarea("Json")
        {
            bind(json)
        }
    }
}