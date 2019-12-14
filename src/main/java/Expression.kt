import optimization.Optimizer
import parsing.TreeNode
import parsing.TreeParser
import validation.impl.SpacedValidator

class Expression(exp: String) {
    private val tokens = exp.split(' ')
    val errors: Set<String>
    val tree: TreeNode
    val forms: Set<List<String>>

    init {
        val validator = SpacedValidator()
        val parser = TreeParser()
        val optimizer = Optimizer()
        validator.validate(exp)

        errors = validator.errors
        if (errors.isEmpty()) {
            tree = parser.parse(tokens)
            forms = optimizer.optimize(tokens)
        } else {
            tree = TreeNode("Error")
            forms = setOf()
        }
    }
}
