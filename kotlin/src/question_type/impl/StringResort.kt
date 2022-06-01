package question_type.impl

/**
 * 시작시간 6:00
 * 끝난시간 6:10
 * 소요시간 10분
 *
 * 코틀린에 문자열을 정령해주는 라이브러리가 존재하지 않았다?!
 */

fun main() {
    val alpha = mutableListOf<Char>()
    var num = 0
    readLine()!!.forEach{
        when(it) {
            in 'A'..'Z' -> alpha.add(it)
            else -> num += it.toString().toInt()
        }
    }
    println("${alpha.sorted().joinToString("")}${if(num > 0) num else ""}")
}