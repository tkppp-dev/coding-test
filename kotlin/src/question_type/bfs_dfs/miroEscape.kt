package question_type.bfs_dfs

import question_type.bfs_dfs.Point
import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val inputs = (0 until n).map {
        readLine()!!.map { it.toString().toInt() }
    }
    val miroEscape = MiroEscape(inputs,  mutableSetOf(), n, m, 0)
    miroEscape.bfs(0, 0)
    println(miroEscape.count + 1)
}

class MiroEscape(
    private val inputs: List<List<Int>>,
    private val visited: MutableSet<Point>,
    private val n: Int,
    private val m: Int,
    var count: Int,
) {
    private fun isOverflow(x: Int, y: Int) = x == -1 || x == n || y == -1 || y == m

    private fun insert(queue: Queue<Point>, x: Int, y: Int) {
        if (!isOverflow(x, y) && Point(x, y) !in visited && inputs[x][y] != 0) {
            queue.add(Point(x, y))
        }
    }

    fun bfs(x: Int, y: Int) {
        var currentQueue: Queue<Point> = LinkedList()
        var nextQueue: Queue<Point> = LinkedList()

        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        visited.add(Point(x, y))
        currentQueue.add(Point(x, y))
        while (true) {
            var flag = 0
            count++
            while(currentQueue.isNotEmpty()){
                val temp = currentQueue.poll()
                for(i in 0 until 4){
                    val nx = temp.x + dx[i];
                    val ny = temp.y + dy[i]
                    if(nx == n - 1 && ny == m - 1) {
                        flag = 1
                        break
                    }
                    insert(nextQueue, nx, ny)
                    visited.add(Point(nx, ny))
                }
                if(flag == 1) break
            }
            if(flag == 1) break;
            currentQueue = nextQueue
            nextQueue = LinkedList()
        }
    }

}
