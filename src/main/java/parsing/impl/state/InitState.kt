package parsing.impl.state

import parsing.abs.statemachine.StateMachine
import parsing.impl.ParserMachine

class InitState : ParserState() {
    override fun transition(machine: ParserMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?) {
        machine.run {
            state = resolver.resolveState(nextSymbol)
            state.transition(this, prevSymbol, currSymbol, nextSymbol)
        }
    }
}