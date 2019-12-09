import parsing.impl.state.NumState
import parsing.impl.state.VarState

fun main() {
    testVarPrevious()
}

fun testNumberFormat() {
    val errors = HashSet<String>()
    val state = NumState()
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
    val state = NumState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, "1.0", errors)
        val msg = errors.toList().getOrElse(0) { "OK token" }
        println(msg)
    }
}

fun testVarFormat() {
    val errors = HashSet<String>()
    val state = VarState()
    while (true) {
        errors.clear()
        print("Variable: ")
        state.validate("", readLine()!!, errors)
        val msg = errors.toList().getOrElse(0) { "Good variable" }
        println(msg)
    }
}

fun testVarPrevious() {
    val errors = HashSet<String>()
    val state = VarState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, "f1", errors)
        val msg = errors.toList().getOrElse(0) { "OK token" }
        println(msg)
    }
}