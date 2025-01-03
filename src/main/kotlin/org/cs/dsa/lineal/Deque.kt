package org.cs.dsa.lineal

data class DequeNode<T>(
    var node: T,
    var previous: DequeNode<T>? = null,
    var next: DequeNode<T>? = null
)

class Deque<T> {
    private var head: DequeNode<T>? = null
    private var last: DequeNode<T>? = null

    private fun isEmpty(): Boolean {
        return head == null
    }

    fun earlyInsert(node: T) {
        val newNode = DequeNode(node, null, head)
        if(isEmpty()) {
            head = newNode
            last = newNode
            return
        }
        head?.previous = newNode
        head = newNode
    }

    fun lastInsert(node: T) {
        val newNode = DequeNode(node, last, null)
        if(isEmpty()){
            head = newNode
            last = newNode
            return
        }

        last?.next = newNode
        last = newNode
    }
}