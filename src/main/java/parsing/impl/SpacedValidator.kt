package parsing.impl

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine
import parsing.abs.statemachine.StateResolver

class SpacedValidator(override val resolver: StateResolver) : StateMachine {
    override lateinit var state: State
}