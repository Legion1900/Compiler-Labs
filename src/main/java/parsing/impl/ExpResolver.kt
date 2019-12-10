package parsing.impl

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateResolver
import parsing.impl.state.*

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