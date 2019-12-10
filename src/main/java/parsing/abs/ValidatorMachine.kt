package parsing.abs

import parsing.abs.statemachine.StateMachine

interface ValidatorMachine : StateMachine{
    val errors: HashSet<String>
    fun validate(exp: String)
}