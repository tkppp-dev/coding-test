package question_type.impl

/**
 * 시작시간 6:19
 * 끝낸시간 6:53
 * 소요시간 34분
 */

fun main(){
    println(solution("aabbaccc"))
}

fun solution(s: String): Int{
    val range = 1..s.length/2
    var min = Int.MAX_VALUE
    for(cut in range){
        val sb = StringBuilder()
        var current = s.substring(0 until cut)
        var next: String; var count = 1
        for(i in cut until s.length step cut){
            try{
                next = s.substring(i until i + cut)
                if(current == next){
                    count++
                    continue
                } else {
                    if(count == 1) sb.append(current)
                    else sb.append("$count$current")
                    current = next; count = 1
                }
            } catch (ex: IndexOutOfBoundsException) {
                if(count == 1) sb.append(current) else sb.append("$count$current")
                if(i < s.length) sb.append(s.substring(i until s.length))
                break
            }
        }
        val result = sb.toString()
        if(min > result.length) min = result.length
    }
    return if(min == Int.MAX_VALUE) 1 else min
}