package question_type.greedy

/**
 * 시작시간 10:38
 * 끝난시간 10:55
 * 소요시간 17분
 *
 * 답과 비교해서 공간 복잡도는 더 높음. 가능한 그룹을 전부 저장하는것이 아니라 현재 최고 공포도와 그룹 인원수를 저장해놓고 비교해도 됨
 * 방향성은 맞았고 메모리를 더 쓰긴하지만 틀릴만하진 않다.
 */

fun main() {
    val n = readLine()!!.toInt()
    val inputs = readLine()!!.split(" ").map{ it.toInt() }.sorted()
    var count = 0
    val group = mutableListOf<Int>()

    for(i in 0 until n){
        if(group.isNotEmpty() && group.size == group.last()) {
            count++
            group.clear()
        } else {
            group.add(inputs[i])
        }
    }
    println(count)
}


fun solution(n: Int, inputs: List<Int>){
    var answer = 0
    var groupCount = 0
    var current = 0

    for(i in 0 until n) {
        current = inputs[i]
        groupCount++
        if(current == groupCount) {
            groupCount = 0
            answer++
        }
    }
    println(answer)
}