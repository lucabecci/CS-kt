package org.cs.dsa.graphs

interface IBreadthFirstSearch<T> {
    fun execute(vertex: T, graph: Graph<T>): MutableSet<T>
}

class BreadthFirstSearch<T> : IBreadthFirstSearch<T> {
    private val visited: MutableSet<T> = mutableSetOf()
    private val queue = ArrayDeque<T>()

    override fun execute(vertex: T, graph: Graph<T>): MutableSet<T> {
        queue.add(vertex)
        visited.add(vertex)

        while(queue.isNotEmpty()) {
            val currentVertex = queue.removeFirst()
            println("Current Vertex: $currentVertex")


            for (neighbor in graph.getNeighbors(currentVertex)) {
                if(neighbor !in visited) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }

        return visited
    }

}