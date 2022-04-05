package programmers.level1

fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    var matched = 0
    var erased = 0

    lottos.forEach {
        if (it == 0) erased++
        else if (it in win_nums) matched++
    }

    val maxOffset = if (matched + erased == 0) 0 else 1
    val minOffset = if (matched == 0) 0 else 1

    return intArrayOf(6 - (matched + erased) + maxOffset, 6 - matched + minOffset)
}