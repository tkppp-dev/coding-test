package programmers

fun solution(call: String): String {
    var max = 0
    var maxSet = mutableSetOf<String>()
    for(i in 1..call.length/2) {
        for(j in 0..call.length - i) {
            val pattern = call.substring(j until j + i)
            val regex = "(?i)${pattern}".toRegex()

            val temp = regex.findAll(call).toList().size
            if(temp > max) {
                max = temp
                maxSet = mutableSetOf(pattern)
            } else if(temp == max) {
                maxSet.add(pattern)
            }
        }
    }
    println("$max, $maxSet")
    var answer = call
    maxSet.forEach {
        val regex = "(?i)${it}".toRegex()
        answer = answer.replace(regex, "")
    }
    return answer
}

fun main() {
    val call = "abcabcdefabc"
    println(solution(call))
}