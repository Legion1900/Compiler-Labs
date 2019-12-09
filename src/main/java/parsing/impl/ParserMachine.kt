package parsing.impl

import parsing.abs.parser.Parser
import parsing.abs.parser.ParserState
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

class ParserMachine(initState: ParserState) : Parser, StateMachine {

    override var state: State = initState

    override fun parse(exp: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}