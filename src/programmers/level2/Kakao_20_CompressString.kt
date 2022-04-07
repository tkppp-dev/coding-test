package programmers.level1

// https://programmers.co.kr/learn/courses/30/lessons/60057

fun solution(s: String): Int {
    var answer = s.length

    for (i in 1..s.length/2) {
        val compressed = StringBuilder()
        var count = 1
        var prev = ""
        var now = ""
        var remain = ""

        for(j in i..s.length - i step i) {
            prev = s.slice(j-i until j)
            now = s.slice(j until j + i)
            remain = s.slice(j + i until s.length)

            if(prev == now) {
                count += 1
                continue
            } else {
                if(count == 1) {
                    compressed.append(prev)
                }
                else {
                    compressed.append("$count$prev")
                    count = 1
                }
            }
        }

        if(count == 1) {
            compressed.append(now)
        }
        else {
            compressed.append("$count$prev")
        }
        compressed.append(remain)

        val length = compressed.length
        if(length < answer) answer = length
    }

    return answer
}

fun main(){
    val s = "ababcdcdababcdcd"
    println(solution(s))
}

