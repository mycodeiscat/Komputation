package com.komputation.models.treediagram

class ExpressionLeaf(name: String) : ExpressionComponent{
    override var value: String = name

    override fun ShowTree(depth: Int) :String{
        return "- $value"
    }

    override fun Add(component: ExpressionComponent): Boolean {
        println("Not supported")
        return false
    }
}