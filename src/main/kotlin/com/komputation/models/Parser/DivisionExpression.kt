package com.komputation.models.Parser

import com.komputation.models.Parser.Expression

class DivisionExpression(private val firstExpression: Expression, private val secondExpression: Expression) :
        Expression {
    override fun interpret(): Int {
        return secondExpression.interpret() / firstExpression.interpret()
    }

    override fun toString(): String {
        return "/"
    }

}