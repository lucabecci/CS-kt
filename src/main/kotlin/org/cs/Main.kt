package org.cs

import org.cs.dsa.DirectGraph

fun main() {
    val graph = DirectGraph<String>()

    graph.addEdge("A", "B")
    graph.addEdge("A", "C")
    graph.addEdge("B", "D")
    graph.addEdge("C", "E")

    graph.print()
}