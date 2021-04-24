package com.komputation.models.Parser

object ExpressionFactory {
     fun isOperator(symbol: String): Boolean {
        return symbol == "+" || symbol == "-" || symbol == "*" || symbol=="/"
    }

     fun getExpressionObject(
             firstExpression: Expression,
             secondExpression: Expression,
             symbol: String
    ): Expression? {
        return if (symbol == "+") AdditionExpression(
            firstExpression,
            secondExpression
        ) else if (symbol == "-") SubtractionExpression(
            firstExpression,
            secondExpression
        ) else if (symbol == "/") DivisionExpression(
                firstExpression,
                secondExpression
        )
          else MultiplicationExpression(firstExpression, secondExpression)
    }
}