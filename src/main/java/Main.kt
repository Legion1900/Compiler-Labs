import parsing.impl.state.NumberState

fun main() {
    testNumberPrevious()
}

fun testNumberFormat() {
    val errors = HashSet<String>()
    val state = NumberState()
    while (true) {
        errors.clear()
        print("Number: ")
        state.validate("", readLine()!!, errors)
        val msg = errors.toList().getOrElse(0) { "Good number" }
        println(msg)
    }
}

fun testNumberPrevious() {
    val errors = HashSet<String>()
    val state = NumberState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, "1.0", errors)
        val msg = errors.toList().getOrElse(0) { "OK token" }
        println(msg)
    }
}