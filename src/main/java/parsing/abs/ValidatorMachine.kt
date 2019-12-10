package parsing.abs

interface ValidatorMachine {
    val errors: HashSet<String>
    fun validate(exp: String)
}