package programmers.level2

// https://programmers.co.kr/learn/courses/30/lessons/42578

fun solution(clothes: Array<Array<String>>)
    = clothes.groupBy { it[1] }.values.fold(1) { answer, el -> answer * (el.size + 1) } - 1

fun main() {
    val clothes = arrayOf(
        arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf(
            "green_turban", "headgear"
        )
    )
    println(solution(clothes))
}