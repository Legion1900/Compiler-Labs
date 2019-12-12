package validation.abs.statemachine

interface StateResolver {
    fun resolveState(nextSymbol: String): State
}