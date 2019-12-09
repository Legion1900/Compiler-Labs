package parsing.abs.parser

import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

interface Parser {
    abstract fun parse(exp: String)
}