package parsing.impl

import parsing.abs.State
import parsing.abs.StateMachine
import parsing.abs.StateResolver

class SpacedValidator(override val resolver: StateResolver) : StateMachine {
    override lateinit var state: State
}