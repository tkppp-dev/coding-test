package question_type.impl

/**
 * 시작시간 5:53
 * 끝난시간 5:57
 * 소요시간 4분
 *
 */

fun main(){
    val input = readLine()!!
    var left = 0; var right = 0

    for(i in 0 until input.length / 2){
        left += input[i].toString().toInt()
        right += input[input.length - i - 1].toString().toInt()
    }

    println(if(left == right) "LUCKY" else "READY")
}
