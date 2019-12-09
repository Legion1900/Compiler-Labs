package parsing.abs

interface State {
    fun validate(prevToken: String, currToken: String, errors: HashSet<String>)
}