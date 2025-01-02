package org.cs.dsa.linkedlist

data class SingleLinkedNode<T>(
    var node: T,
    var next: SingleLinkedNode<T>? = null
)

class SingleLinkedList<T> {
    private var head: SingleLinkedNode<T>? = null

    fun isEmpty(): Boolean {
        return head == null
    }

    fun earlyInsert(node: T) {
        val newNode = SingleLinkedNode<T>(node, head)
        head = newNode
    }

    fun lastInsert(node: T) {
        if(isEmpty()) {
            head = SingleLinkedNode(node)
            return
        }

        var actualHead = head
        while (actualHead?.next != null) {
            actualHead = actualHead.next
        }
        actualHead?.next = SingleLinkedNode(node)
    }

    fun find(node: T): Boolean {
        var actualNode = head
        while (actualNode != null) {
            if(actualNode.node == node) return true
            actualNode = actualNode.next
        }
        return false
    }

    fun delete(node: T): Boolean {
        if(isEmpty()) return false

        if(head?.node == node) {
            head = head?.next
            return true
        }

        var actual = head
        while(actual?.next != null) {
            if(actual.next?.node == node){
                actual.next = actual.next?.next
                return true
            }
            actual = actual.next
        }
        return false
    }

    fun values(): List<T> {
        val listOfNodes = mutableListOf<T>()

        var actual = head
        while (actual != null) {
            listOfNodes.add(actual.node)
            actual = actual.next
        }

        return listOfNodes
    }
}