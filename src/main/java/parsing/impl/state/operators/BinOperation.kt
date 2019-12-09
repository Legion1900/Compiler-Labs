package parsing.impl.state.operators

import parsing.abs.parser.Validator
import parsing.impl.ParserMachine
import parsing.impl.state.ParserState

/*
* Represents simple binary operations such as +, *, /
* but not -, this one is special.
* */
open class BinOperation : ParserState(), Validator {

    private val operators = listOf('+', '-', '*', '/')

    override fun transition(machine: ParserMachine, prevSymbol: Char?, currSymbol: Char?, nextSymbol: Char?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validate(prev: Char?, curr: Char?, next: Char?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}