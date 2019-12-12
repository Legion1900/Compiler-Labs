package parsing

import java.lang.StringBuilder

class TreeNode(
        val token: String,
        var leftChild: TreeNode? = null,
        var rightChild: TreeNode? = null
) {
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