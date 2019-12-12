package validation.impl

import validation.abs.statemachine.State
import validation.abs.statemachine.StateResolver
import validation.impl.state.*

class ExpResolver : StateResolver {
    private val transitions = mapOf(
            NUMBER to NumState(),
            VAR to VarState(),
            OP to OpState(),
            SCOPE to ScopeState()
    )

    private val errState = ErrorState()

    override fun resolveState(nextSymbol: String): State {
        for (key in transitions.keys) {
            if (nextSymbol.matches(key))
                return transitions.getValue(key)
        }
        return errState
    }
}