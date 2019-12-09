package parsing.abs.statemachine

import parsing.abs.statemachine.State

interface StateMachine {
    var state: State
    val resolver: StateResolver
}