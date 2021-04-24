package com.komputation.models.Parser

class LiteralExpression : Expression {
    private var literal : String

    constructor(literal: String) {
        this.literal = literal
    }

    override fun interpret(): Int {
        return 1
    }
}