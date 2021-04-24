package com.komputation.models.Parser

import java.util.*


class ExpressionParser : AbstractParser {
    var stack = Stack<Expression>()
    override fun parse(str: String): Int {
        val tokenList = str.split(" ".toRegex()).toTypedArray()
        for (symbol in tokenList) {
            if (!ExpressionFactory.isOperator(symbol) && !symbol.isBlank()) {
                val numberExpression: Expression = NumberExpression(symbol)
                stack.push(numberExpression)
                println(String.format("Pushed to stack: %d", numberExpression.interpret()))
            } else if (ExpressionFactory.isOperator(symbol)) {
                val firstExpression: Expression = stack.pop()
                val secondExpression: Expression = stack.pop()
                println(
                        String.format(
                                "Popped operands %d and %d",
                                firstExpression.interpret(), secondExpression.interpret()
                        )
                )
                val operator: Expression? =
                        ExpressionFactory.getExpressionObject(firstExpression, secondExpression, symbol)
                println(String.format("Applying Operator: %s", operator))
                val result = operator?.interpret()
                val resultExpression = result?.let { NumberExpression(it) }
                stack.push(resultExpression)
                if (resultExpression != null) {
                    println(String.format("Pushed result to stack: %d", resultExpression.interpret()))
                }
            }
        }
        return stack.pop().interpret()
    }
}
