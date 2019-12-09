package parsing.impl

import parsing.abs.parser.Parser
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine
import parsing.abs.statemachine.StateResolver
import parsing.impl.state.InitState

class ParserMachine(override val resolver: StateResolver) : Parser, StateMachine {
    override var state: State = InitState

    override fun parse(exp: String) {
        for (i in exp.indices) {
            val prev = exp.getOrNull(i - 1)
            val curr = exp[i]
            val next = exp.getOrNull(i + 1)
            state.transition(this, prev, curr, next)
        }
    }
}