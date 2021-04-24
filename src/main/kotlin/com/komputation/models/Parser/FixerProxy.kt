package com.komputation.models.Parser

import infixToPostfix

class FixerProxy : AbstractParser {
    private val parser : AbstractParser = ExpressionParser()

    private fun check( str: String) : String
    {
        val sb = StringBuilder(str)
        var i = 1
        while(i < sb.length)
        {
            var check = sb[i];
            if(sb[i].isLetter() && sb[i-1].isDigit())
            {
                sb.insert(i, '*')
            }
            if(ExpressionFactory.isOperator(sb[i].toString()) && !sb[i+1].isWhitespace()) sb.insert(i+1, ' ')
            if(ExpressionFactory.isOperator(sb[i].toString()) && !sb[i-1].isWhitespace())
            {
                sb.insert(i, ' ')
            }
            i++
        }

        return sb.toString()
    }

    override fun parse(str: String): Int {
        return parser.parse(infixToPostfix(check(str)))
    }
}

