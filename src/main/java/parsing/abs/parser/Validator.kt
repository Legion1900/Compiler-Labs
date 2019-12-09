package parsing.abs.parser

interface Validator {
    fun validate(prev: Char?, curr: Char?, next: Char?): Boolean
}