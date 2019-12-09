package parsing.impl.state

import parsing.abs.parser.ParserState
import parsing.abs.statemachine.StateMachine

object InitState : ParserState() {
    override fun transition(machine: StateMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?) {
        machine.run {
            state = resolver.resolveState(nextSymbol)
            state.transition(this, prevSymbol, currSymbol, nextSymbol)
        }
    }
}