package parsing.impl.state

import parsing.abs.State

class NumberState : State {

    private val regex = Regex(PATTERN)

    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        if (!currToken.matches(regex))
            errors += ERR_MSG
    }

    private companion object {
        const val PATTERN = "\\d+(\\.\\d+)?"

        const val ERR_MSG = "Number may contain only digits and one dot"
    }
}