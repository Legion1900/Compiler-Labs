import optimization.Optimizer
import parsing.TreeParser
import validation.impl.SpacedValidator
import validation.impl.state.NumState
import validation.impl.state.OpState
import validation.impl.state.ScopeState
import validation.impl.state.VarState

fun main() {
    while (true) {
        print("Expression: ")
        val exp = Expression(readLine()!!)
        if (exp.errors.isEmpty()) {
            println("Expression tree: ")
            print(exp.tree)
            println("Alternative forms: ")
            exp.forms.forEach { tokens ->
                tokens.forEach { print(it) }
                println()
            }
        } else exp.errors.forEach { System.err.println(it) }
    }
}

fun testOptimizer() {
    val opt = Optimizer()
    val builder = StringBuilder()
    while (true) {
        print("Expression: ")
        val forms = opt.optimize(readLine()!!.split(' '))
        println("Equivalent forms: ")
        for (exp in forms) {
            exp.forEach { builder.append(it) }
            println("   $builder")
            builder.clear()
        }
    }
}

fun testTreeParser() {
    val parser = TreeParser()
    while (true) {
        print("Expression: ")
        val root = parser.parse(readLine()!!.split(' '))
        println(root.toString())
    }
}

fun testPostfix() {
    val parser = TreeParser()
    parser.parse(readLine()!!.split(' '))
}

fun testValidator() {
    val validator = SpacedValidator()
    while (true) {
        print("Expression: ")
        validator.validate(readLine()!!)
        for (e in validator.errors)
            System.err.println(e)
        validator.errors.clear()
    }
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

fun testOpFormat() {
    val errors = HashSet<String>()
    val state = OpState()
    while (true) {
        errors.clear()
        print("Operator: ")
        state.validate("var", readLine()!!, errors)
        val msg = errors.toList().getOrElse(0) { "Good operator" }
        println(msg)
    }
}

fun testOpPrevious() {
    val errors = HashSet<String>()
    val state = OpState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, "-", errors)
        val msg = errors.toList().getOrElse(0) { "OK token" }
        println(msg)
    }
}

fun testOpenScope() {
    val errors = HashSet<String>()
    val state = ScopeState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, "(", errors)
        val msg = errors.toList().getOrElse(0) { "OK usage" }
        println(msg)
    }
}

fun testClosingScope() {
    val errors = HashSet<String>()
    val state = ScopeState()
    while (true) {
        errors.clear()
        print("Previous token: ")
        state.validate(readLine()!!, ")", errors)
        val msg = errors.toList().getOrElse(0) { "OK usage" }
        println(msg)
    }
}