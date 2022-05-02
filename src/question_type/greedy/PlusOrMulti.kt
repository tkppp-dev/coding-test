package question_type.greedy

/**
 * 시작시간 11:05
 * 끝난시간 11:08
 * 소요시간 3분
 *
 * 정답
 */

fun main(){
    val string = readLine()!!
    val answer = string.fold(1) { total, next ->
        when(val n = next.toString().toInt()){
            0,1 -> total + n
            else -> total * n
        }
    }
    println(answer)
}