package dsa

import org.graphs.dsa.DirectGraph
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach


class DirectGraphTest {
    private lateinit var directGraph: DirectGraph<String>

    @BeforeEach
    fun setup() {
        directGraph = DirectGraph()
    }

    @Test
    fun `Save a new Vertex`() {
        assertDoesNotThrow {
            directGraph.addVertex("A")
        }
    }

    @Test
    fun `Save a new Edge`() {
        assertDoesNotThrow {
            directGraph.addVertex("A")
            directGraph.addVertex("B")
            directGraph.addEdge("A", "B")
        }
    }

    @Test
    fun `Validate the Neighbors of A`() {
        val firstVertex = "A"
        val secondVertex = "B"
        directGraph.addVertex("A")
        directGraph.addVertex("B")

        directGraph.addEdge(firstVertex, secondVertex)

        val firstVertexExpectedNeighbors = listOf<String>(secondVertex)
        val secondVertexExpectedNeighbors = emptyList<String>()

        assertEquals(firstVertexExpectedNeighbors, directGraph.getNeighbors(firstVertex))
        assertEquals(secondVertexExpectedNeighbors, directGraph.getNeighbors(secondVertex))
    }

    @Test
    fun `Get the correct path with DFS`(){
        val vertexA = "A"
        val vertexB = "B"
        val vertexC = "C"
        val vertexD = "D"

        directGraph.addListOfVertex(listOf<String>(
            vertexA,
            vertexB,
            vertexC,
            vertexD,
        ))

        directGraph.addEdge(vertexA, vertexB)
        directGraph.addEdge(vertexB, vertexC)
        directGraph.addEdge(vertexC, vertexD)

        val dfsResult = directGraph.depthFirstSearch(vertexA).toList()
        assertEquals(4, dfsResult.size)
        assertEquals(vertexA, dfsResult[0])
        assertEquals(vertexB, dfsResult[1])
        assertEquals(vertexC, dfsResult[2])
        assertEquals(vertexD, dfsResult[3])
    }
}