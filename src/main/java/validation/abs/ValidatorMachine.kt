package validation.abs

import validation.abs.statemachine.StateMachine

interface ValidatorMachine : StateMachine{
    val errors: HashSet<String>
    fun validate(exp: String)
}