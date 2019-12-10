package parsing.abs.statemachine

import parsing.abs.statemachine.State

interface StateResolver {
    fun resolveState(nextSymbol: String): State
}