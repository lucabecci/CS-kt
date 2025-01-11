package org.cs.dsa.lineal

class DequeNode<T>(
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

    fun earlyDelete(): T? {
        if (isEmpty()) return null
        val node = head?.node
        head = head?.next

        if(head == null) {
            last = null
        } else {
            head?.previous = null
        }

        return node
    }

    fun lastDelete(): T? {
        if(isEmpty()) return null
        val node = last?.node
        val previous = last?.previous

        if(previous == null) {
            head = null
        } else {
            previous.next = null
        }
        return node
    }


    fun values(): List<T> {
        var elements = mutableListOf<T>()

        var actualNode = head

        while(actualNode != null) {
            elements.add(actualNode.node)
            actualNode = actualNode.next
        }

        return elements
    }
}