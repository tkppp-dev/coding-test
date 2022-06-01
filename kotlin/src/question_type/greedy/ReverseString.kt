package question_type.greedy

/**
 * 시작시간 11:12
 * 끝낸시간 11:31
 * 소요시간 19분
 *
 * 바보같이 이전문제 실행시키다가 늦음
 */

fun main() {
    val string = readLine()!!
    var count0 = 0;
    var count1 = 0

    var prev = if (string[0] == '0') {
        count0++
        '0'
    } else {
        count1++
        '1'
    }

    for (i in 1 until string.length) {
        if (prev != string[i]) {
            if (string[i] == '0') count0++ else count1++
            prev = string[i]
        }
    }

    println(minOf(count0, count1))
}