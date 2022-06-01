package programmers.level1

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val lostPersons = mutableListOf<Int>()
    val lostButReserve = mutableSetOf<Int>()
    val reserveList = (0..n + 1).map { 0 }.toIntArray()

    lost.sort()

    reserve.forEach { reserveList[it] = 1 }
    lost.forEach {
        if (reserveList[it] == 1) {
            reserveList[it] = 0
            lostButReserve.add(it)
        }
    }
    lost.forEach {
        if (reserveList[it - 1] == 1) reserveList[it - 1] = 0
        else if (reserveList[it + 1] == 1) reserveList[it + 1] = 0
        else if(it !in lostButReserve) lostPersons.add(it)
    }

    return n - lostPersons.size
}

fun main() {
    val n = 7
    val lost = intArrayOf(3,4,6)
    val reserve = intArrayOf(1,2,4,7)
    println(solution(n, lost, reserve))
}