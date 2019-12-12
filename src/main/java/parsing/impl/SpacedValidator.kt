package parsing.impl

import parsing.abs.ValidatorMachine
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateResolver
import parsing.impl.state.EMPTY_SCOPES
import parsing.impl.state.OpState
import parsing.impl.state.ScopeState

class SpacedValidator : ValidatorMachine {
    override lateinit var state: State
    override val resolver: StateResolver = ExpResolver()
    override val errors: HashSet<String> = HashSet()

    override fun validate(exp: String) {
        ScopeState.resetCounter()
        val tokens = exp.split(' ')
        for (i in tokens.indices) {
            val prevToken = tokens.getOrElse(i - 1) { "" }
            val currToken = tokens[i]
            state = resolver.resolveState(currToken)
            state.validate(prevToken, currToken, errors)
        }
        checkScopeCount()
        checkEmptyScopes(exp)
        checkLastSymbol(tokens.last())
    }

    private fun checkEmptyScopes(exp: String) {
        if (exp.contains(EMPTY_SCOPES))
            errors += EMPTY_SCOPES_ERR
    }

    private fun checkLastSymbol(token: String) {
        state = resolver.resolveState(token)
        when (state) {
            is OpState -> errors += LAST_OP_ERR
            is ScopeState -> if (token == "(")
                errors += LAST_SCOPE_ERR
        }
    }

    private fun checkScopeCount() {
        if (!ScopeState.isClosed)
            errors += SCOPE_ERR
    }

    private companion object {
        const val SCOPE_ERR = "There should be as many closed scopes as there are open scopes"
        const val LAST_OP_ERR = "Operators cannot be placed in the end"
        const val LAST_SCOPE_ERR = "Opening scope cannot be placed in the end"
        const val EMPTY_SCOPES_ERR = "Cannot use empty scopes"
    }
}