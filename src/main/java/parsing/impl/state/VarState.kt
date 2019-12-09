package parsing.impl.state

import parsing.abs.State

class VarState : State {
    override fun validate(prevToken: String, currToken: String, errors: HashSet<String>) {
        if (!(currToken.matches(VAR)))
            errors += VAR_NAME_ERR
        if (prevToken.matches(NUM_VAR_SCOPE))
            errors += WRONG_PREV_ERR
    }

    private companion object {
        const val VAR_NAME_ERR = "Variable name must start with letter can contain only English letters and numbers"
        const val WRONG_PREV_ERR = "Variable cannot be placed after another number, variable, or closing scope"
    }
}