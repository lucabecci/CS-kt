package dsa

import org.cs.dsa.graphs.DepthFirstSearch
import org.cs.dsa.graphs.DirectGraph
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

        val depthFirstSearch = DepthFirstSearch<String>()
        val dfsResult = depthFirstSearch.execute(vertexA, directGraph).toList()
        assertEquals(4, dfsResult.size)
        assertEquals(vertexA, dfsResult[0])
        assertEquals(vertexB, dfsResult[1])
        assertEquals(vertexC, dfsResult[2])
        assertEquals(vertexD, dfsResult[3])
    }

    /**
     * A first.
     * Then B, C, F (left side).
     * Then D, E (right side).
     */
    @Test
    fun `Get the correct path with DFS for letters`() {
        val vertexA = "A"
        val vertexB = "B"
        val vertexC = "C"
        val vertexD = "D"
        val vertexE = "E"
        val vertexF = "F"

        val graph = DirectGraph<String>()
        graph.addListOfVertex(listOf(
            vertexA, vertexB, vertexC, vertexD, vertexE, vertexF
        ))

        graph.addEdge(vertexA, vertexB)
        graph.addEdge(vertexB, vertexC)
        graph.addEdge(vertexB, vertexD)
        graph.addEdge(vertexD, vertexE)
        graph.addEdge(vertexC, vertexF)

        val depthFirstSearch = DepthFirstSearch<String>()
        val dfsResult = depthFirstSearch.execute(vertexA, graph).toList()

        assertEquals(6, dfsResult.size)
        assertEquals(listOf(vertexA, vertexB, vertexC, vertexF, vertexD, vertexE), dfsResult)
    }


    @Test
    fun `Get the correct path with BFS`() {
        val vertexA = "A"
        val vertexB = "B"
        val vertexC = "C"
        val vertexD = "D"

        val directGraph = DirectGraph<String>()
        directGraph.addListOfVertex(listOf(
            vertexA,
            vertexB,
            vertexC,
            vertexD,
        ))

        directGraph.addEdge(vertexA, vertexB)
        directGraph.addEdge(vertexB, vertexC)
        directGraph.addEdge(vertexC, vertexD)

        val bfsResult = directGraph.breadthFirstSearch(vertexA).toList()

        assertEquals(4, bfsResult.size)
        assertEquals(vertexA, bfsResult[0])
        assertEquals(vertexB, bfsResult[1])
        assertEquals(vertexC, bfsResult[2])
        assertEquals(vertexD, bfsResult[3])
    }


    /**
     * A
     * B, C, D (level 1, direct neighbors of A).
     * E, F, G, H (level 2, neighbors of B, C, y D).
     */
    @Test
    fun `Validate BFS with multiple edges per vertex`() {
        val vertexA = "A"
        val vertexB = "B"
        val vertexC = "C"
        val vertexD = "D"
        val vertexE = "E"
        val vertexF = "F"
        val vertexG = "G"
        val vertexH = "H"

        val graph = DirectGraph<String>()
        graph.addListOfVertex(listOf(
            vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH
        ))

        graph.addEdge(vertexA, vertexB)
        graph.addEdge(vertexA, vertexC)
        graph.addEdge(vertexA, vertexD)
        graph.addEdge(vertexB, vertexE)
        graph.addEdge(vertexB, vertexF)
        graph.addEdge(vertexC, vertexG)
        graph.addEdge(vertexD, vertexH)

        val bfsResult = graph.breadthFirstSearch(vertexA).toList()

        assertEquals(8, bfsResult.size)
        assertEquals(listOf(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH), bfsResult)
    }


}