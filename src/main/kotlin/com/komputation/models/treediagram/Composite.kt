package com.komputation.models.treediagram


class Composite(name: String) : ExpressionComponent
{
    override var value: String = name

    var _children:MutableList<ExpressionComponent> = mutableListOf()

    override fun Add(component : ExpressionComponent) = _children.add(component)
    fun Remove(component: ExpressionComponent){
        _children = _children.filter{ it != component }.toMutableList()
    }

    override fun ShowTree(depth: Int) : String {
        var result = value
        for(i in 0..depth) result += '-'
        for (item : ExpressionComponent in _children)
        {
            result += "${item.ShowTree(depth+2)}\n"
        }
        return result
    }
}
