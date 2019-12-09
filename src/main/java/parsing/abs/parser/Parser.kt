package parsing.abs.parser

interface Parser {
    val errors: Set<String>
    fun parse(exp: String)
}