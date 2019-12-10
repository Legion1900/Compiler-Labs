package parsing.impl.state

import parsing.abs.State

class OpState : State {
    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        validateFormat(currToken, errors)
        validatePrev(prevToken, errors)
    }

    private fun validateFormat(currToken: String, errors: HashSet<String>) {
        if (!currToken.matches(OP))
            errors += FORMAT_ERR
    }

    private fun validatePrev(prevToken: String, errors: HashSet<String>) {
        if (!prevToken.matches(NUM_VAR_SCOPE))
            errors += WRONG_PREV_ERR
    }

    companion object {
        const val FORMAT_ERR = "Only allowed operators are: +, -, *, /"
        const val WRONG_PREV_ERR = "+, *, / operators can only be placed after numbers, closing scopes, or variables"
    }
}