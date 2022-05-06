package kakao.internship2021

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 * 시작시간 2:07
 * 끝난시간 2:14
 * 소요시간 7
 */

fun main() {
    println(solution("23four5six7"))
}

fun solution(s: String): Int {
    val wordNumbers = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    var answer = s
    for((i, word) in wordNumbers.withIndex()){
        answer = answer.replace(word.toRegex(), i.toString())
    }
    return answer.toInt()
}