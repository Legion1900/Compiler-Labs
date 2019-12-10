package parsing.impl.state

import parsing.abs.statemachine.State

class ErrorState : State {
    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        errors += ERR
    }

    private companion object {
        const val ERR = "Unrecognized token"
    }
}