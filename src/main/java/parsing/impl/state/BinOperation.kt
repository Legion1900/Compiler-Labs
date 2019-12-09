package parsing.impl.state

import parsing.abs.parser.ParserState
import parsing.abs.parser.Validator
import parsing.abs.statemachine.State
import parsing.abs.statemachine.StateMachine

/*
* Represents simple binary operations such as +, *, /
* but not -, this one is special.
* */
object BinOperation : ParserState(), Validator{
    override fun transition(machine: StateMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validate(prev: Char?, curr: Char?, next: Char?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}