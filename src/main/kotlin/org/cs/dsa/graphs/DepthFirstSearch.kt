package org.cs.dsa.graphs

interface IDepthFirstSearch<T> {
    fun execute(vertex: T, graph: Graph<T>): MutableSet<T>
}

class DepthFirstSearch<T>:IDepthFirstSearch<T> {
    override fun execute(vertex: T, graph: Graph<T>): MutableSet<T> {
        val visited: MutableSet<T> = mutableSetOf()
        fun dfsRunner(v: T) {
            if (v in visited) return
            visited.add(v)
            println("Vertex visited: $v")
            for (neighbor in graph.getNeighbors(v)) {
                println("Neighbor to visit: $neighbor")
                dfsRunner(neighbor)
            }
        }
        dfsRunner(vertex)
        return visited
    }
}