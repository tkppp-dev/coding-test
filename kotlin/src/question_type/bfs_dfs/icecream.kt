package question_type.bfs_dfs

data class Point(val x: Int, val y: Int)

val visited = mutableSetOf<Point>()

fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val inputs = (0 until n).map {
        readLine()!!.trim().split(" ").map { it.toInt() }
    }
    println(inputs)
    dfsSolution(inputs, n, m)
}

fun dfsSolution(inputs: List<List<Int>>, n: Int, m: Int) {
    var count = 0
    for (i in inputs.indices) {
        for (j in inputs[i].indices) {
            if (Point(i, j) !in visited && inputs[i][j] == 1) {
                dfs(inputs, i, j, n, m)
                count++
            }
        }
    }
    println(count)
}

fun isOverflow(x: Int, y: Int, n: Int, m: Int) = x == -1 || x == n || y == -1 || y == m

fun dfs(inputs: List<List<Int>>, x: Int, y: Int, n: Int, m: Int) {
    if (isOverflow(x, y, n, m) || inputs[x][y] == 0 || Point(x, y) in visited) return
    else {
        visited.add(Point(x, y))
        dfs(inputs, x + 1, y, n, m)
        dfs(inputs, x, y + 1, n, m)
        dfs(inputs, x - 1, y + 1, n, m)
        dfs(inputs, x, y - 1, n, m)
    }
}

