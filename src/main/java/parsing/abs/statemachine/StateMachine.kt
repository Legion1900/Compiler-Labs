package parsing.abs.statemachine

interface StateMachine {
    var state: State
    val resolver: StateResolver
}