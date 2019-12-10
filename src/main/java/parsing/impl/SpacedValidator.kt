package parsing.impl

import parsing.abs.ValidatorMachine
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateResolver
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
        if (!ScopeState.isClosed)
            errors += SCOPE_ERR
    }

    private companion object {
        const val SCOPE_ERR = "There should be as many closed scopes as there are open scopes"
    }
}