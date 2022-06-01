package question_type.impl

import kotlin.math.absoluteValue

/**
 * 시작시간 6:51
 * 끝난시간 8:06
 *
 * 생각나는 방법은 완전탐색. 범위가 작게 주어진걸 보면 가능할듯
 * 1개일 때 치킨 거리, 2개일때 치킨 거리 ... m개일 때 치킨거리를 각각 다 시뮬레이션 돌려서 최소값을 찾아야할듯
 */

private var n = 0
private var m = 0;
private val chickens = mutableListOf<Pair<Int, Int>>()
private val homes = mutableListOf<Home>()
private var answer = Int.MAX_VALUE

data class Home(val x: Int, val y: Int, val chickenLengths: MutableList<Int> = mutableListOf()) {
    fun calcChickenLength(chicken: Pair<Int, Int>) {
        chickenLengths.add((x - chicken.first).absoluteValue + (y - chicken.second).absoluteValue)
    }
}

fun calcCombination(check: Array<Boolean>, start: Int, target: Int) {
    if (target == 0) {
        val combi = mutableListOf<Int>()
        check.forEachIndexed { idx, el ->
            if (el) combi.add(idx)
        }
        var sum = 0
        for(home in homes){
            var min = Int.MAX_VALUE
            for(chicken in combi) {
                min = minOf(min, home.chickenLengths[chicken])
            }
            sum += min
        }
        answer = minOf(answer, sum)
    } else {
        for (i in start until chickens.size) {
            check[i] = true
            calcCombination(check, i + 1, target - 1)
            check[i] = false
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    repeat(n) { i ->
        readLine().split(" ").forEachIndexed { j, value ->
            val temp = value.toInt()
            if (temp == 1) homes.add(Home(i, j))
            else if (temp == 2) chickens.add(i to j)
        }
    }
    // 치킨 거리 미리 구하기
    for (home in homes) {
        for (chicken in chickens) {
            home.calcChickenLength(chicken)
        }
    }

    for(i in 1..m){
        calcCombination(Array(13){ false }, 0, i)
    }
    println(answer)
}