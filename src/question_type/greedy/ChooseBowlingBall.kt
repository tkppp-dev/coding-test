package question_type.greedy

import programmers.level2.result

/**
 * 시작시간 1:08
 * 끝난시간 1:29
 * 소요시간 19분
 *
 * 그리디 유형인데 조합으로 풀어버림...
 *
 * 특정 무게의 공의 개수를 세는 방법 -> 배열을 선언하고 순회하면서 무게를 배열의 인덱스의 값에다가 ++해준다
 * -> 쉽게는 groupBy
 */

fun combination(a: Int, b: Int): Int{
    val x = (a - b + 1..a).fold(1){total, next -> total * next }
    val y = (2..b).fold(1){total, next -> total*next}
    return x/y
}
fun main() {
    val (n,m) = readLine()!!.split(" ").map{ it.toInt() }
    val inputs = readLine()!!.split(" ").map{ it.toInt() }

    solution(n, m, inputs)
    /*
    val (n,m) = readLine()!!.split(" ").map{ it.toInt() }
    val inputs = readLine()!!.split(" ").groupBy { it }.filter { it.value.size > 1 }.map{ it.value.size }

    val total = combination(n, 2)
    val exception = inputs.fold(0){total, next -> total + combination(next, 2) }

    println(total - exception)
     */
}

fun solution(n: Int, m: Int, inputs: List<Int>){
    val ballCount = inputs.groupBy { it }

    var remainBalls = n
    var answer = 0
    for(input in inputs){
        remainBalls -= ballCount[input]!!.size
        if(remainBalls == 0) break;
        answer += ballCount[input]!!.size * remainBalls
    }

    println(answer)
}