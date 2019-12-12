package parsing

class TreeNode(
        val token: String,
        var leftChild: TreeNode? = null,
        var rightChild: TreeNode? = null
) {

    override fun toString(): String {
        val builder = StringBuilder()
        printTree(builder)
        return builder.toString()
    }

    private fun printTree(builder: StringBuilder, prefix: String = "", childPrefix: String = "") {
        builder.append(prefix)
                .append(token)
                .append('\n')
        leftChild?.printTree(builder, "$childPrefix|--- ", "$childPrefix|   ")
        rightChild?.printTree(builder, "$childPrefix└--- ", "$childPrefix   ")
    }

    companion object {
        /*
        * Well, in MY ORDER traversal.
        *       ¯\_(ツ)_/¯
        * */
        fun inOrderTraversal(root: TreeNode): String {
            val builder = StringBuilder()
            fun traverse(node: TreeNode?) {
                node?.run {
                    traverse(rightChild)
                    builder.append(token)
                    traverse(leftChild)
                }
            }

            traverse(root)
            return builder.toString()
        }
    }
}