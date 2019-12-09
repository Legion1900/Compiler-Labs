package parsing.abs

import parsing.abs.State

interface StateResolver {
    fun resolveState(nextSymbol: String): State
}