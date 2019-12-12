package validation.abs.statemachine

interface State {
    fun validate(prevToken: String, currToken: String, errors: HashSet<String>)
}