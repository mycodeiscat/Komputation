package com.komputation.models.Parser

import com.komputation.models.Parser.Expression

class AdditionExpression(private val firstExpression: Expression, private val secondExpression: Expression) :
        Expression {
    override fun interpret(): Int {
        return firstExpression.interpret() + secondExpression.interpret()
    }

    override fun toString(): String {
        return "+"
    }

}

