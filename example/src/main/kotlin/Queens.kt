import kotlin.math.abs

fun main(args: Array<String>) {
    val N = 9;
    val board = ChessBoard(N)
    val unsafe = hashSetOf<Position>()
    for (file in 0 until N)
        for (rank in 0 until N) {
            val pos = Position(file, rank)
            if (!board.isSafe(pos))
                unsafe.add(pos)
        }
    board.queens.addAll(unsafe)
    board.isSolvable(0)
    board.printOut()
}

typealias Position = Pair<Int, Int>

val Position.file: Int get() = this.first
val Position.rank: Int get() = this.second


class ChessBoard(val N: Int) {
    val queens = hashSetOf<Position>()

//    init {
//        queens.add(Position(3, 4))
//    }


    fun isSolvable(file: Int): Boolean {
        if (file >= N)
            return true
        for (rank in 0 until N) {
            val pos = Position(file, rank)
            if (isSafe(pos)) {
                queens.add(pos)
                if (isSolvable(file + 1)) {
                    return true
                } else {
                    queens.remove(pos)
                }
            }
        }
        return false
    }

    fun isSafe(pos: Position): Boolean {
        for (q in queens) {
            if (q.rank == pos.rank
                || q.file == pos.file
                || abs(q.file - pos.file) == abs(q.rank - pos.rank)
            )
                return false
        }
        return true
    }

    fun printOut() {
        for (rank in N - 1 downTo 0) {
            print("${rank + 1}|")
            for (file in 0 until N) {
                val pos = Position(file, rank)
                print("${if (pos in queens) "Q" else "_"}|")
            }
            println()
        }
        print("  ")
        for (file in 0 until N) {
            print("${'A' + file} ")
        }
    }


}