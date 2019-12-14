package optimization

import java.util.*

class DeepScopeOptimizer {
    fun optimize(exp: List<String>): List<String> {
        val scopes = findScopes(exp)
        for (nesting in scopes.keys) {
            scopes.getValue(nesting).forEach { print("$it ") }
            println()
        }
        TODO("Finish me")
    }

    private fun findScopes(exp: List<String>): Map<Int, List<Pair<Int, Int>>> {
        val scopes = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        val opened = Stack<Int>()
        for (i in exp.indices) {
            if (exp[i] == "(")
                opened += i
            if (exp[i] == ")") {
//                TODO: fix this, doesn't work with couple of scopes on same level
                scopes[opened.size]?.run {
                    add(opened.pop() to i)
                } ?: run {
                    val list = mutableListOf(opened.pop() to i)
                    scopes[opened.size] = list
                }
            }
        }
        return scopes
    }
}