package programmers.level1

// https://programmers.co.kr/learn/courses/30/lessons/92334

data class ReportData(
    val user: String,
    val reported: MutableSet<String> = mutableSetOf(),   // 자신이 신고한 유저 리스트
    val banned: MutableSet<String> = mutableSetOf(),     // 자신을 신고한 유저 리스트
)

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val reportMap = hashMapOf<String, ReportData>()

    for (id in id_list) {
        reportMap += id to ReportData(id)
    }

    for (element in report) {
        val result = element.split(" ")
        val reporter = result.first()
        val respondent = result.last()

        reportMap[reporter]!!.reported.add(respondent)
        reportMap[respondent]!!.banned.add(reporter)
    }

    val bannedList = mutableListOf<String>()
    for (id in id_list) {
        if (reportMap[id]!!.banned.size >= k) bannedList += id
    }

    val answer = IntArray(id_list.size) { _ -> 0 }

    for ((idx, id) in id_list.withIndex()) {
        bannedList.forEach {
            if (it in reportMap[id]!!.reported) answer[idx] += 1
        }
    }

    return answer
}

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k = 2

    solution(id_list, report, k)
}