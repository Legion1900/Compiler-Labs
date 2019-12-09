package parsing.abs

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

abstract class ParserState : State {

    abstract val symbol: String

    override fun transition(machine: StateMachine, vararg args: Any?) {
        if (args.size != 2)
            throw IllegalArgumentException(ERR_MSG)
        transition(machine, args[0], args[1])
    }

    abstract fun transition(machine: StateMachine, prevSymbol: Char?, nextSymbol: Char?)

    companion object {
        private const val ERR_MSG = "You must send exactly two arguments: previous and next symbols."
    }
}