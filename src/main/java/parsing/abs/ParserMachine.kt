package parsing.abs

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

abstract class ParserMachine(initialState: ParserState) : StateMachine {

    override var state: State = initialState

    abstract fun parse(exp: String)
}