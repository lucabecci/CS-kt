package dsa

import org.cs.dsa.tree.BinarySearchTree
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class BinarySearchTreeTest {
    private lateinit var binarySearchTree: BinarySearchTree<Int>

    @BeforeEach
    fun setup(){
        binarySearchTree = BinarySearchTree()
    }

    @Test
    fun `Run insert with ASC comparator`() {
        val nodeA = 1
        val nodeB = 22
        val nodeC = -1

        val comparator = Comparator<Int>{a, b -> a - b}

        assertDoesNotThrow {
            binarySearchTree.insert(nodeA, comparator)
            binarySearchTree.insert(nodeC, comparator)
            binarySearchTree.insert(nodeB, comparator)
        }
    }

    @Test
    fun `Run insert with DESC comparator`() {
        val nodeA = 1
        val nodeB = 22
        val nodeC = -1

        val comparator = Comparator<Int>{a, b -> b - a}

        assertDoesNotThrow {
            binarySearchTree.insert(nodeA, comparator)
            binarySearchTree.insert(nodeC, comparator)
            binarySearchTree.insert(nodeB, comparator)
        }
    }

    @Test
    fun `Run in order traversal with ASC comparator`() {
        val nodeA = 1
        val nodeB = 22
        val nodeC = -1

        val comparator = Comparator<Int>{a, b -> a - b}

        binarySearchTree.insert(nodeA, comparator)
        binarySearchTree.insert(nodeC, comparator)
        binarySearchTree.insert(nodeB, comparator)

        /**
         *  -1 LEFT + 1 ROOT + 22 RIGHT
         */
        val expectedSequence = listOf(nodeC, nodeA, nodeB)

        assertDoesNotThrow {
            val sequenceResult = binarySearchTree.inOrderTraversal(binarySearchTree.getRoot())
            Assertions.assertEquals(sequenceResult.size, 3)
            Assertions.assertEquals(expectedSequence, sequenceResult)
        }

    }

    @Test
    fun `Run in order traversal with DESC comparator`() {
        val nodeA = 1
        val nodeB = 22
        val nodeC = -1

        val comparator = Comparator<Int>{a, b -> b - a}

        binarySearchTree.insert(nodeA, comparator)
        binarySearchTree.insert(nodeC, comparator)
        binarySearchTree.insert(nodeB, comparator)

        /**
         *  22 LEFT + 1 ROOT + -1 RIGHT
         */
        val expectedSequence = listOf(nodeB, nodeA, nodeC)

        assertDoesNotThrow {
            val sequenceResult = binarySearchTree.inOrderTraversal(binarySearchTree.getRoot())
            Assertions.assertEquals(sequenceResult.size, 3)
            Assertions.assertEquals(expectedSequence, sequenceResult)
        }

    }

    @Test
    fun `Run height`() {
        val listOfNodeValues = listOf(1, 22, -1, 2, 44, 23)

        val comparator = Comparator<Int>{a, b -> a - b}

        listOfNodeValues.forEach{
                node -> binarySearchTree.insert(node, comparator)
        }

        val expectedResult= 4

        assertDoesNotThrow {
            val result = binarySearchTree.height(binarySearchTree.getRoot())
            Assertions.assertNotNull(result)
            Assertions.assertEquals(expectedResult, result)
        }

    }
}