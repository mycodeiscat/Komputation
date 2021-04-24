package com.komputation.models.command

import com.komputation.models.Parser.AppEngine

class FormulaCommand : Command {
    constructor(engine: AppEngine, input: String)
    {
        this.reciever = engine
        this.text = input
    }
    override fun Execute(): String {
        return reciever.execute(text)
    }
}