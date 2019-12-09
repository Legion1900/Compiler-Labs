package parsing.impl.state

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine
import parsing.impl.ParserMachine

abstract class ParserState : State {

    override fun transition(machine: StateMachine, vararg args: Any?) {
        if (args.size != 3)
            throw IllegalArgumentException(ERR_MSG)
        transition(machine, args[0] as Char?, args[1] as Char?, args[2] as Char?)
    }

    abstract fun transition(machine: ParserMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?)

    companion object {
        private const val ERR_MSG = "You must send exactly two arguments: previous and next symbols."
    }
}