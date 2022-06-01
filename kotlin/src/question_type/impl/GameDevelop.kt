package question_type.impl

fun getNext(direction: Int) =
    when (direction) {
        0 -> Pair(-1, 0)
        1 -> Pair(0, 1)
        2 -> Pair(1, 0)
        else -> Pair(0, -1)
    }

fun getBehind(direction: Int) =
    when (direction) {
        0 -> Pair(1, 0)
        1 -> Pair(0, -1)
        2 -> Pair(-1, 0)
        else -> Pair(0, 1)
    }


fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    var (x, y, direction) = readLine()!!.split(" ").map { it.toInt() }
    val map = List(n + 2) {
        MutableList(m + 2) { -1 }
    }
    (0 until n).forEachIndexed { _x, _ ->
        readLine()!!.split(" ").forEachIndexed { _y, data -> map[_x + 1][_y + 1] = data.toInt() }
    }

    var flag = 0
    var moveCount = 0
    x += 1; y += 1

    while (true) {
        for (i in 0 until 4) {
            direction = if (direction == 0) 3 else direction - 1
            val (nextX, nextY) = getNext(direction)
            if (map[x + nextX][y + nextY] == 0) {
                flag = 1
                map[x][y] = 2
                x += nextX
                y += nextY
                moveCount++
                break
            }
        }
        if (flag == 0) {
            val (behindX, behindY) = getBehind(direction)
            if (map[x + behindX][y + behindY] == -1 || map[x + behindX][y + behindY] == 1) break
            else {
                moveCount++
                map[x][y] = 2
                x += behindX
                y += behindY
            }
        }
        flag = 0
    }

    println(moveCount)
}