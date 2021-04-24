package com.komputation.models.export

import com.komputation.models.Parser.ExpressionFactory
import com.komputation.models.treediagram.Composite
import com.komputation.models.treediagram.ExpressionComponent
import com.komputation.models.treediagram.ExpressionLeaf
import infixToPostfix
import java.util.*

class TREEexport : ExportBuilder() {
    fun constructTree(postfix: String): ExpressionComponent? {
        val st: Stack<ExpressionComponent?> = Stack<ExpressionComponent?>()
        var t: ExpressionComponent?
        var t1: ExpressionComponent?
        var t2: ExpressionComponent?
        val tokenList = postfix.split(" ".toRegex()).toTypedArray()
        for (i in tokenList) {
            if(i.isNotBlank()) {
                if (!ExpressionFactory.isOperator(i)) {
                    t = ExpressionLeaf(i.toString())
                    st.push(t)
                } else  // operator
                {
                    t = Composite(i.toString())
                    t1 = st.pop()
                    t2 = st.pop()

                    if (t1 != null) {
                        t.Add(t1)
                    }
                    if (t2 != null) {
                        t.Add(t2)
                    }
                    st.push(t)
                }
            }
        }
        t = st.peek()
        st.pop()
        return t
    }

    override fun SetHeader() {
        file.header = "Expression tree"
    }

    override fun SetContent(content: String) {
        val postfix = infixToPostfix(content)
        val head = constructTree(postfix)
        if (head != null) {
           file.content = head.ShowTree(0)
        }
    }

    override fun SetFooter() {
        file.footer = "\n"
    }
}