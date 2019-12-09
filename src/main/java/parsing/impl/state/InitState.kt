package parsing.impl.state

import parsing.abs.parser.ParserState
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

object InitState : ParserState() {
    override fun transition(machine: StateMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?) {
        machine.state = resolveState(nextSymbol)
        machine.state.transition(machine, prevSymbol, currSymbol, nextSymbol)
    }

    override fun resolveState(nextSymbol: Char?): State {
        TODO("Add resolving logic")
    }
}