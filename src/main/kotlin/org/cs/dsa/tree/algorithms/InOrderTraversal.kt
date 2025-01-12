package org.cs.dsa.tree.algorithms

import org.cs.dsa.tree.TreeNode

/**
 * Left -> Root -> Right -> Repeat
 */
class InOrderTraversal<T> {
    fun <T> execute(node: TreeNode<T>?, result: MutableList<T> = mutableListOf()): List<T> {
        if(node != null){
            execute(node.left, result)
            println("In Order Traversal: ${node.value}")
            result.add(node.value)
            execute(node.right, result)

        }
        return result
    }
}