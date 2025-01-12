package org.cs.dsa.tree.algorithms

import org.cs.dsa.tree.TreeNode

/**
 * Left -> Right -> Root -> Repeat
 */
class PostOrderTraversal<T>{
    fun <T> execute(node: TreeNode<T>?, result: MutableList<T> = mutableListOf()): List<T> {
        if(node != null) {
            execute(node.left, result)
            execute(node.right, result)
            println("Post Order Traversal: ${node.value}")
            result.add(node.value)
        }

        return result
    }
}