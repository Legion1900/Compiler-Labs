package optimization

class Optimizer {
    fun optimize(exp: List<String>): List<String> {
        val scopes = findScopes(exp)
        val out = mutableListOf<String>()
        var start = 0
        for (s in scopes) {
            out += exp.subList(start, s.first)
            start = s.second
            val sub = exp.subList(s.first, s.second + 1)
            var optimized = factorOut(sub, "*")
            optimized = factorOut(optimized, "/")
            out += optimized
        }

        return out
    }

    private fun findScopes(exp: List<String>): List<Pair<Int, Int>> {
        val scopes = mutableListOf<Pair<Int, Int>>()
        for (i in exp.indices) {
            if (exp[i] == "(") {
                var j = i
                while (exp[j] != ")") {
                    j++
                }
                scopes += i to j
            }
        }
        return scopes
    }

    /*
    * subExp - expression inside parentheses
    * return: Map<operand, List<index of operator occurrence>>
    * */
    private fun factorOut(subExp: List<String>, op: String): List<String> {
        // Map of <Operands, List<indexes of operators>
        val occurrences = mutableMapOf<String, MutableList<Int>>()
        for (i in subExp.indices)
            if (subExp[i] == op) {
                val operand = subExp[i + 1]
                if (occurrences.containsKey(operand))
                    occurrences.getValue(operand) += i
                else occurrences[operand] = mutableListOf(i)
            }
        val common = occurrences.filter { it.value.size > 1 }
        val exp = mutableListOf<String>()
        val commonOut = mutableListOf<String>()
        exp += subExp
        // Building common factor out.
        for (operand in common.keys) {
            commonOut += op
            commonOut += operand
        }
        // Delete common factor inside scope.
        val positions = common.flatMap { it.value }.sorted().reversed()
        for (pos in positions) {
            exp.removeAt(pos + 1)
            exp.removeAt(pos)
        }
        // Appending common factor.
        exp += commonOut

        return exp
    }
}