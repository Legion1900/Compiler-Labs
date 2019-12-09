package parsing.impl.state

import parsing.abs.State

class NumberState : State {

    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        if (!currToken.matches(NUMBER))
            errors += NUM_FORMAT_ERR
        if (prevToken.matches(WRONG_PREV))
            errors += WRONG_PREV_ERR
    }

    private companion object {
        val WRONG_PREV = Regex("$NUMBER|$VAR|[)]")

        const val NUM_FORMAT_ERR = "Number may contain only digits and one dot"
        const val WRONG_PREV_ERR = "Number cannot be placed after another number, variable, or closing scope"
    }
}