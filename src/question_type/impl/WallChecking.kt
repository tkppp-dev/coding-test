package question_type.impl

/**
 * 시작시간 6:38
 *
 * 한명으로 점검이 가능한지 체크후 안되면 2명, 3명, ... , max(8)까지
 * 점검 가능한 거리가 적은 친구가 되면 긴 친구가 안되겠어? 점검 순서는 긴 친구부터
 */

fun main() {
    println(solution(12, intArrayOf(1, 5, 6, 10), intArrayOf(1, 2, 3, 4)))
}

fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
    val weakMap = hashMapOf<Int, Pair<Int, Int>>()
    weak.forEachIndexed { i, _ ->
        val circleDist = if (i != weak.size - 1) {
            weak[i + 1] - weak[i]
        } else {
            n - weak[i] + weak[0]
        }
        val reverseDist = if (i > 0) {
            weak[i] - weak[i - 1]
        } else {
            weak[i] + n - weak[weak.size - 1]
        }
        weakMap[weak[i]] = Pair(reverseDist, circleDist)
    }

    val sortedDist = dist.sortedDescending()
    for (i in 1..dist.size) {
        for (start in weak.indices) {
            val friends = (i - 1 downTo 0).map {
                sortedDist[it]
            }.toMutableList()

            val check = mutableSetOf<Int>()
            var sum = 0
            var reverseIdx = start
            var circleIdx = start

            while(friends.isNotEmpty()){
                val reverse = weakMap[weak[reverseIdx]]!!.first
                val circle = weakMap[weak[circleIdx]]!!.second
                val min = minOf(reverse, circle)

                if(sum + min < friends.last()){
                    sum += min
                    if(reverse < circle){
                        check.add(reverseIdx)
                        if(reverseIdx == 0) reverseIdx = weak.size - 1
                        else reverseIdx--
                    } else {
                        check.add(circleIdx)
                        if(circleIdx == weak.size - 1) circleIdx = 0
                        else circleIdx++
                    }
                    if(check.size == weak.size) return 1
                } else {
                    friends.removeLast()
                }
            }

        }
    }
    return -1
}
