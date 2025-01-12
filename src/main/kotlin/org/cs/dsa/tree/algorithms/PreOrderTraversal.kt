package org.cs.dsa.tree.algorithms

import org.cs.dsa.tree.TreeNode

/**
 * Root -> Left -> Right -> Repeat
 */
class PreOrderTraversal<T> {
    fun <T> execute(node: TreeNode<T>?, result: MutableList<T> = mutableListOf()): List<T> {
        if (node != null) {
            result.add(node.value)
            println("Pre Order Traversal: ${node.value}")
            execute(node.left, result)
            execute(node.right, result)
        }

        return result
    }
}