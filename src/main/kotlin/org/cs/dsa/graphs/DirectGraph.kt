package org.cs.dsa.graphs

/**
 * A Direct Graph implementation with:
 * 1. DFS
 */
class DirectGraph<T>:Graph<T> {
    /**
     * State of the Direct Graph
     */
    private val state = mutableMapOf<T, MutableList<T>>()

    override fun addVertex(vertex: T) {
        if(!state.containsKey(vertex)) {
            println("New Vertex added in the state, value: $vertex")
            state[vertex] = mutableListOf()
        }
    }

    override fun addListOfVertex(listOfVertex: List<T>) {
        for (vertex in listOfVertex){
            addVertex(vertex)
        }
    }

    override fun addEdge(from: T, to: T){
        addVertex(from)
        addVertex(to)
        println("New Edge added in the state, values: \n A: $from \n B: $to")
        state[from]?.add(to)
    }

    override fun getNeighbors(vertex: T): List<T> {
        return state[vertex] ?: emptyList()
    }

    override fun print() {
        for ((vertex, neighbors) in state) {
            println("Vertex: $vertex \n Neighbors $neighbors")
        }
    }
}