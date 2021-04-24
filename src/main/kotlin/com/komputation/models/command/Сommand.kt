package com.komputation.models.command

import com.komputation.models.Parser.AppEngine

abstract class Command
{
    protected lateinit var reciever : AppEngine
    var text : String =""
    abstract fun Execute() : Any;
}
