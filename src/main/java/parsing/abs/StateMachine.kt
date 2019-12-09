package parsing.abs

interface StateMachine {
    var state: State
    val resolver: StateResolver
}