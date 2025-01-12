package org.cs.dsa.tree



class BinarySearchTree<T> {
    private var root: TreeNode<T>? = null
    fun getRoot(): TreeNode<T>? = root

    fun insert(value: T, comparator: Comparator<T>) {
        root = insertRecursively(root, value, comparator)
    }



    fun <T> preOrderTraversal(node: TreeNode<T>?) {
        if (node != null) {
            println(node.value)
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
    }

    fun height(node: TreeNode<T>?): Int {
        return if(node == null) 0 else 1 + maxOf(height(node.left), height(node.right))
    }

    private fun insertRecursively(node: TreeNode<T>?, value: T,  comparator: Comparator<T>): TreeNode<T> {
        if(node == null){
            val treeNode = TreeNode(value)
            println("New root Node added: $treeNode")
            return treeNode
        }

        if(comparator.compare(value, node.value) < 0) {
            node.left = insertRecursively(node.left, value, comparator)
            println("New node added in left side of node $node, the value is: $value")
        } else {
            node.right = insertRecursively(node.right, value, comparator)
            println("New node added in right side of node $node, the value is: $value")
        }

        return node
    }
}