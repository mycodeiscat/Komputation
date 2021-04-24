package com.komputation.models.command

import com.komputation.models.Parser.AppEngine

object CommandManager {
    lateinit var engine : AppEngine
    private var actionHistory: MutableList<Command> =  mutableListOf<Command>()
    fun Compute(input: String) : String
    {
        val command = FormulaCommand(engine, input)
        actionHistory.add(command)
        return command.Execute();
    }

    fun getLastCommands(number: Int) : MutableList<Command>
    {
        return actionHistory
    }
}