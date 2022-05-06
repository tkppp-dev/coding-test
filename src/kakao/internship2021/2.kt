package kakao.internship2021

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 *
 * 시작시간 2:16
 * 끝난시간
 * 소요시간 38분
 *
 * bfs 에서 peek 을 요상한데서 하고 있었음...
 */

fun main(){

}

fun getPersonPosition(room: Array<String>): Array<Pair<Int, Int>> {
    val person = mutableListOf<Pair<Int, Int>>()
    for(i in room.indices){
        for(j in room[i].indices){
            if(room[i][j] == 'P') person.add(i to j)
        }
    }
    return person.toTypedArray()
}

fun isOverflow(i: Int, j: Int) = i < 0 || i > 4 || j < 0 || j > 4

fun check(room: Array<String>): Int{
    // t r b l
    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(-1, 0, 1, 0)
    val persons = getPersonPosition(room)
    for(person in persons){
        val queue = arrayListOf<Pair<Int,Int>>()
        queue.add(person)
        var depth = 0
        while(queue.isNotEmpty() && depth < 2){
            val cp = queue.last()
            for(i in 0 until 4){
                val x = cp.first + dx[i]
                val y = cp.second + dy[i]
                if(isOverflow(x,y) || Pair(x,y) == person) continue
                else {
                    when(room[x][y]){
                        'P' -> return 0
                        'O' -> queue.add(0, x to y)
                        else -> continue
                    }
                }
            }
            depth++
            queue.removeLast()
        }
    }
    return 1
}

fun solution(places: Array<Array<String>>): IntArray {
    val answer = places.map { check(it) }
    return answer.toIntArray()
}