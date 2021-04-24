package com.komputation.view

import com.komputation.models.export.ExportDirector
import com.komputation.models.export.TREEexport
import com.komputation.models.export.XMLexport
import tornadofx.*

class TreeController : Controller() {
    var result  = ""
    fun setInput(input : String)
    {
        this.result = input
    }
    fun build() : String {
        val builder = ExportDirector()
        val tree = builder.exportFile(TREEexport(), result)
        return tree.content
    }
}

class TreeView : Fragment("Export Tree") {
    val controller: TreeController by inject()

    override val root = vbox{
        label(controller.build())
    }
}