typealias Node = Char

val graph:
        Map<Node, Map<Node, Int>> =
    mapOf(
        'A' to mapOf('B' to 10, 'E' to 9),
        'B' to mapOf('C' to 2, 'F' to 5),
        'C' to mapOf('G' to 15, 'D' to 5),
        'D' to mapOf('H' to 9),
        'E' to mapOf('F' to 7, 'I' to 8),
        'F' to mapOf('G' to 12, 'J' to 13),
        'G' to mapOf('H' to 1, 'K' to 6),
        'H' to mapOf('L' to 5),
        'I' to mapOf('J' to 3, 'M' to 11),
        'J' to mapOf('K' to 4, 'N' to 9),
        'K' to mapOf('L' to 2, 'O' to 5),
        'L' to mapOf('P' to 9),
        'M' to mapOf('N' to 6),
        'N' to mapOf('O' to 1),
        'O' to mapOf('P' to 7)
    )


fun main() {
    val unvisited = ('A'..'P').toMutableSet()
    val dist = hashMapOf<Node, Int>()
    val prev = hashMapOf<Node, Node>()
    dist['A'] = 0
    while (unvisited.isNotEmpty()) {
        //Take the node with minimum distance (and its distance)
        val entry = requireNotNull(
            dist.filter { it.key in unvisited }
                .minBy { it.value })
        val (u, distU) = entry
        unvisited.remove(u)
        //For each neighbour v of u still unvisited
        graph[u].orEmpty()
            .filter { it.key in unvisited }
            .forEach { edge ->
                val v = edge.key
                val alt = distU + edge.value
                val distV = dist[v]
                if (distV == null || alt < distV) {
                    dist[v] = alt
                    prev[v] = u
                }
            }
    }

    var n: Node? = 'P'
    while (n != null) {
        print("$n->")
        n = prev[n]
    }
    println(dist['P'])
}