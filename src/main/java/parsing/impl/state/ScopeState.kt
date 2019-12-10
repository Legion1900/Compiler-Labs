package parsing.impl.state

import parsing.abs.State

class ScopeState : State {
    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        when (currToken) {
            "(" -> handleOpenScope(prevToken, errors)
            ")" -> handleClosingScope(prevToken, errors)
        }
    }

    private fun handleOpenScope(prevToken: String, errors: HashSet<String>) {
        cnt++
        if (prevToken.isNotEmpty() && !prevToken.matches(OP) && prevToken != "(")
            errors += WRONG_OPEN
    }

    private fun handleClosingScope(prevToken: String, errors: HashSet<String>) {
        cnt--
        if (prevToken != "(" && !prevToken.matches(NUM_VAR_SCOPE))
            errors += WRONG_CLOSE
    }

    companion object {
        private var cnt = 0
        val isClosed
            get() = cnt == 0
        fun resetCounter() {
            cnt = 0
        }

        private const val WRONG_OPEN = "Opening scope cannot be placed after number, variable, or closing scope"
        private const val WRONG_CLOSE = "Closing scope cannot be placed on beginning of expression or after operator"
    }
}