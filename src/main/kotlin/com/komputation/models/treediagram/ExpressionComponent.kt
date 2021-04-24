package com.komputation.models.treediagram

interface ExpressionComponent {
    var value : String

    fun Add(component : ExpressionComponent) : Boolean
    fun ShowTree(depth: Int) : String
}
