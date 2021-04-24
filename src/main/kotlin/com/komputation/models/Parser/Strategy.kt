package com.komputation.models.Parser

interface Strategy {
    fun execute(input : String) : String
}