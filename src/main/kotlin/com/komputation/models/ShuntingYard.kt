
import java.util.Stack

const val OPS = "-+/*^"

fun infixToPostfix(infix: String): String {
    val ops = "-+/*^"

    val sb = StringBuilder()
    val s = Stack<Int>()

    for (token in infix.split(" ")) {
        if (token.isEmpty()) continue
        val c = token[0]
        val idx = ops.indexOf(c)
        // check for operator
        if (idx != -1) {
            if (s.isEmpty()) s.push(idx) else {
                while (!s.isEmpty()) {
                    val prec2 = s.peek() / 2
                    val prec1 = idx / 2
                    if (prec2 > prec1 || prec2 == prec1 && c != '^') sb.append(ops[s.pop()]).append(' ') else break
                }
                s.push(idx)
            }
        } else if (c == '(') {
            s.push(-2) // -2 stands for '('
        } else if (c == ')') { // until '(' on stack, pop operators.
            while (s.peek() != -2) sb.append(ops[s.pop()]).append(' ')
            s.pop()
        } else {
            sb.append(token).append(' ')
        }
    }
    while (!s.isEmpty()) sb.append(ops[s.pop()]).append(' ')
    println(sb.toString())
    return sb.toString()
}