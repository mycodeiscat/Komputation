package com.komputation.models.Parser

class CalculationStrategy : Strategy {
    override fun execute(input: String): String {
        val parser = FixerProxy()
        return parser.parse(input).toString()
    }
}