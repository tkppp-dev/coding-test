package question_type.impl

import java.util.*

/**
 * 시작시간 4:51
 * 끝낸시간 6:02
 * 소요시간 1:19
 *
 * 문제를 잘못 읽어서 구현을 잘못해 삽질 오지게 함 하...
 *
 * 풀이방식이나 방향성은 맞았고 회전 방식을 잘못 본것이 문제 -> 문제좀 잘읽어라!
 */

// top = 0, right = 1, bottom = 2, left = 3
fun getDirection(dir: Int) = when(dir){
    0 -> Pair(-1, 0)
    1 -> Pair(0, 1)
    2 -> Pair(1, 0)
    else -> Pair(0, -1)
}

fun main() {
    val n = readLine()!!.toInt()
    val map = Array(n + 2) { i ->
        IntArray(n + 2) { j ->
            if (i == 0 || i == n + 1 || j == 0 || j == n+1) -1 else 0
        }
    }
    val k = readLine()!!.toInt()
    repeat(k) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        map[x][y] = 1
    }
    val l = readLine()!!.toInt()
    val rotateInfo: Queue<Pair<Int, String>> = LinkedList()
    repeat(l) {
        val (time, dir) = readLine()!!.split(" ")
        rotateInfo.add(Pair(time.toInt(), dir))
    }

    val snake = mutableListOf(Pair(1,1))
    map[1][1] = 2
    var direction = 1
    var time = 0

    while(true){
        if(rotateInfo.peek() != null && rotateInfo.peek().first == time){
            val rotate = rotateInfo.poll()
            if(rotate.second == "D"){
                direction++
                if(direction > 3) direction %= 4
            } else {
                direction--
                if(direction == -1) direction = 3
            }
        }
        val chead = snake.last()
        val next = getDirection(direction)
        val nhead = Pair(chead.first + next.first, chead.second + next.second)

        if(map[nhead.first][nhead.second] == -1 || map[nhead.first][nhead.second] == 2) {
            break;
        } else {
            snake.add(nhead)
            if(map[nhead.first][nhead.second] != 1){
                val tail = snake.removeAt(0)
                map[tail.first][tail.second] = 0
            }
            map[nhead.first][nhead.second] = 2
        }
        time++
    }
    println(time + 1)
}