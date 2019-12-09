package parsing.abs.statemachine

interface StateResolver {
    fun resolveState(nextSymbol: Char?): State
}