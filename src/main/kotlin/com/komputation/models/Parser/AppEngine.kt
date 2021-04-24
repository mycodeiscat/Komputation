package com.komputation.models.Parser

class AppEngine {
    private var currentStrategy : Strategy = CalculationStrategy()

    fun changeStrategy(strategy : Strategy)
    {
        currentStrategy = strategy
    }

    fun execute(input: String): String {
        return currentStrategy.execute(input)
    }
}