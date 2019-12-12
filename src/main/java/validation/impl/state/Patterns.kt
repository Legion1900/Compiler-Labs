package validation.impl.state

val NUMBER = Regex("-?\\d+(\\.\\d+)?")

val VAR = Regex("[a-zA-Z]+\\w*")

val OP = Regex("[+\\-*/]")

val SCOPE = Regex("[()]")

val NUM_VAR_SCOPE = Regex("$NUMBER|$VAR|[)]")

val EMPTY_SCOPES = Regex("\\(\\s\\)")