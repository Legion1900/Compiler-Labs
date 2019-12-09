package parsing.impl.state

val NUMBER = Regex("\\d+(\\.\\d+)?")

val VAR = Regex("[a-zA-Z]+\\w*")

val NUM_VAR_SCOPE = Regex("$NUMBER|$VAR|[)]")