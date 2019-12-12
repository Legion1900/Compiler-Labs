package validation.abs.statemachine

interface StateMachine {
    var state: State
    val resolver: StateResolver
}