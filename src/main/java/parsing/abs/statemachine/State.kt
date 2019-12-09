package parsing.abs.statemachine

interface State {
    fun transition(machine: StateMachine, vararg args: Any?)
}