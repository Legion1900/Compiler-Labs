package parsing

import validation.impl.ExpResolver
import validation.impl.state.NumState
import validation.impl.state.OpState
import validation.impl.state.ScopeState
import validation.impl.state.VarState
import java.util.*

class TreeParser {

    private val resolver = ExpResolver()

    private val precedence = mapOf(
            "(" to 0,
            "+" to 1,
            "-" to 1,
            "*" to 2,
            "/" to 2
    )

    fun parse(tokens: List<String>): TreeNode {
        val postfix = infixToPostfix(tokens)
        val operands = Stack<TreeNode>()
        fun resolveOp(token: String) {
            val right = operands.pop()
            val left = operands.pop()
            operands += TreeNode(token, right, left)
        }
        for (token in postfix)
            when (resolver.resolveState(token)) {
                is NumState -> operands += TreeNode(token)
                is VarState -> operands += TreeNode(token)
                is OpState -> resolveOp(token)
            }

        return operands.pop()
    }

    private fun infixToPostfix(tokens: List<String>): List<String> {
        val opStack = Stack<String>()
        val out = mutableListOf<String>()
        fun resolveOp(token: String) {
            while (opStack.isNotEmpty() && opStack.peek().precedence >= token.precedence)
                out += opStack.pop()
            opStack += token
        }

        fun resolveScopes(token: String) {
            when (token) {
                "(" -> opStack += token
                ")" -> while (true) {
                    val op = opStack.pop()
                    if (op == "(")
                        break
                    else out += op
                }
            }
        }

        for (t in tokens) {
            when (resolver.resolveState(t)) {
                is NumState -> out += t
                is VarState -> out += t
                is OpState -> resolveOp(t)
                is ScopeState -> resolveScopes(t)
            }
        }
        while (opStack.isNotEmpty())
            out += opStack.pop()

        return out
    }

    private val String.precedence
        get() = this@TreeParser.precedence.getValue(this)
}