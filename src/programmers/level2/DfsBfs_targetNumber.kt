package programmers.level2

// https://programmers.co.kr/learn/courses/30/lessons/43165

val result = mutableListOf<Int>()
var targetNumber: Int = 0

fun calculate(sum: Int, numbers: IntArray, dep: Int) {
    if(dep == numbers.size) {
        if(sum == targetNumber) result.add(sum)
        return
    } else {
        val left = sum - numbers[dep]
        val right = sum + numbers[dep]

        calculate(left, numbers, dep + 1)
        calculate(right, numbers, dep + 1)
    }
}

fun solution(numbers: IntArray, target: Int): Int {
    targetNumber = target
    calculate(0, numbers, 0)
    return result.size
}