package dsa

import org.cs.dsa.lineal.Deque
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.*

class DequeTest {
    private lateinit var deque: Deque<String>

    @BeforeEach
    fun setup(){
        deque = Deque()
    }

    @Test
    fun `Run early insert`() {
        val nodeA = "A"
        val nodeB = "B"
        assertDoesNotThrow {
            deque.earlyInsert(nodeA)
            deque.earlyInsert(nodeB)
        }
    }

    @Test
    fun `Run last insert`() {
        val nodeA = "A"
        val nodeB = "B"
        assertDoesNotThrow {
            deque.lastInsert(nodeA)
            deque.lastInsert(nodeB)
        }
    }

    @Test
    fun `Run early delete`(){
        val nodeA = "A"
        val nodeB = "B"

        deque.earlyInsert(nodeA)
        deque.earlyInsert(nodeB)

        val nodeDeleted = deque.earlyDelete()

        assertNotNull(nodeDeleted)
        assertEquals(nodeB, nodeDeleted)
    }

    @Test
    fun `Run last delete`() {
        val nodeA = "A"
        val nodeB = "B"
        val nodeC = "C"

        deque.lastInsert(nodeA)
        deque.lastInsert(nodeB)
        deque.earlyInsert(nodeC)

        val nodeDeleted = deque.lastDelete()

        assertNotNull(nodeDeleted)
        assertEquals(nodeB, nodeDeleted)
    }

    @Test
    fun `Run values method`() {
        val nodeA = "A"
        val nodeB = "B"
        val nodeC = "C"
        val nodeD = "D"

        deque.lastInsert(nodeB)
        deque.earlyInsert(nodeA)
        deque.earlyInsert(nodeD)
        deque.lastInsert(nodeC)

        val elements = deque.values()
        val expectedElements = mutableListOf(nodeD, nodeA, nodeB, nodeC)
        assertEquals(4, elements.size)
        assertEquals(expectedElements, elements)
    }
}