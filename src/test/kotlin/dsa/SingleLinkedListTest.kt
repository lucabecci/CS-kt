package dsa

import org.cs.dsa.linkedlist.SingleLinkedList
import org.cs.dsa.linkedlist.SingleLinkedNode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SingleLinkedListTest {
    private lateinit var linkedList: SingleLinkedList<String>
    private val nodeA = "A"
    private val nodeB = "B"
    private val nodeC = "C"

    @BeforeEach()
    fun setup() {
        linkedList = SingleLinkedList<String>()
    }

    @Test
    fun `Find a valid Node`() {
        linkedList.lastInsert(nodeC)
        linkedList.lastInsert(nodeB)
        linkedList.lastInsert(nodeA)

        val findResult = linkedList.find(nodeB)

        assertTrue(findResult)
    }

    @Test
    fun `Find a invalid Node`() {
        linkedList.earlyInsert(nodeC)
        linkedList.earlyInsert(nodeA)

        val findResult = linkedList.find(nodeB)

        assertFalse(findResult)
    }

    @Test
    fun `Delete a Node`() {
        linkedList.earlyInsert(nodeC)
        linkedList.earlyInsert(nodeB)
        linkedList.earlyInsert(nodeA)

        val findResult = linkedList.find(nodeB)

        assertTrue(findResult)

        val isDeleted = linkedList.delete(nodeB)
        assertTrue(isDeleted)

        val findResultAfterDeleteOperation = linkedList.find(nodeB)
        assertFalse(findResultAfterDeleteOperation)
    }

    @Test
    fun `Get all Nodes`() {
        val expectedList = listOf(nodeC, nodeB, nodeA)

        linkedList.earlyInsert(nodeC)
        linkedList.lastInsert(nodeB)
        linkedList.lastInsert(nodeA)

        val values = linkedList.values()

        assertNotNull(values)

        assertEquals(expectedList, values)
    }
}