package com.komputation.models.Parser

class NumberExpression : Expression {
        private var number: Int

        constructor(number: Int) {
            this.number = number
        }

        constructor(number: String) {
            this.number = number.toInt()
        }

        override fun interpret(): Int {
            return number
        }
}