package org.cs.dsa.graphs

/**
 * A Direct Graph implementation with:
 * 1. DFS
 */
class DirectGraph<T> {
    /**
     * State of the Direct Graph
     */
    private val state = mutableMapOf<T, MutableList<T>>()

    /**
     * Adds a new Vertex
     */
    fun addVertex(vertex: T) {
        if(!state.containsKey(vertex)) {
            println("New Vertex added in the state, value: $vertex")
            state[vertex] = mutableListOf()
        }
    }

    /**
     * Iterate in list of Vertex and adds it
     */
    fun addListOfVertex(listOfVertex: List<T>) {
        for (vertex in listOfVertex){
            addVertex(vertex)
        }
    }

    /**
     * Adds a new Edge into two Vertex
     */

    fun addEdge(from: T, to: T){
        addVertex(from)
        addVertex(to)
        println("New Edge added in the state, values: \n A: $from \n B: $to")
        state[from]?.add(to)
    }

    /**
     * Get the Neighbors of a Graph
     */
    fun getNeighbors(vertex: T): List<T> {
        return state[vertex] ?: emptyList()
    }


    /**
     * Show the State of the Graph
     */
    fun print() {
        for ((vertex, neighbors) in state) {
            println("Vertex: $vertex \n Neighbors $neighbors")
        }
    }

    fun depthFirstSearch(vertex: T): MutableSet<T> {
        val visited: MutableSet<T> = mutableSetOf<T>()
        fun dfsRunner(v: T) {
            if (v in visited) return
            visited.add(v)
            println("Vertex visited: $v")
            for (neighbor in getNeighbors(v)) {
                println("Neighbor to visit: $neighbor")
                dfsRunner(neighbor)
            }
        }
        dfsRunner(vertex)
        return visited
    }

    fun breadthFirstSearch(vertex: T): MutableSet<T> {
        val visited: MutableSet<T> = mutableSetOf<T>()
        val queue = ArrayDeque<T>()

        queue.add(vertex)
        visited.add(vertex)

        while(queue.isNotEmpty()) {
            val currentVertex = queue.removeFirst()
            println("Current Vertex: $currentVertex")


            for (neighbor in getNeighbors(currentVertex)) {
                if(neighbor !in visited) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }

        return visited
    }

}