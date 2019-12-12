package validation.impl.state

import validation.abs.statemachine.State

class NumState : State {

    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        if (!(currToken.matches(NUMBER)))
            errors += NUM_FORMAT_ERR
        if (prevToken.matches(NUM_VAR_SCOPE))
            errors += WRONG_PREV_ERR
    }

    private companion object {


        const val NUM_FORMAT_ERR = "Number may contain only digits and one dot"
        const val WRONG_PREV_ERR = "Number cannot be placed after another number, variable, or closing scope"
    }
}