package org.cs.dsa.graphs

interface Graph<T> {
    /**
     * Adds a new Vertex
     */
    fun addVertex(vertex: T)

    /**
     * Iterate in list of Vertex and adds it
     */
    fun addListOfVertex(listOfVertex: List<T>)

    /**
     * Adds a new Edge into two Vertex
     */
    fun addEdge(from: T, to: T)

    /**
     * Get the Neighbors of a Graph
     */
    fun getNeighbors(vertex: T): List<T>

    /**
     * Show the State of the Graph
     */
    fun print()
}