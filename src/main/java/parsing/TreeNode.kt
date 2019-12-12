package parsing

class TreeNode(
        val token: String,
        var leftChild: TreeNode? = null,
        var rightChild: TreeNode? = null
)