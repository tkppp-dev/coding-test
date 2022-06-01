package question_type.impl

/**
 * 시작시간 7:55
 * 중단시간 9:36
 * 1차 소요시간 1:41
 *
 * 역시나 문제를 잘못 이해했다. 이해한게 맞는지 다시한번 생각하는 시간을 충분히 가져야 할듯
 *
 * arrayOf(
intArrayOf(1, 0, 0, 1),
intArrayOf(1, 1, 1, 1),
intArrayOf(2, 1, 0, 1),
intArrayOf(2, 2, 1, 1),
intArrayOf(5, 0, 0, 1),
intArrayOf(5, 1, 0, 1),
intArrayOf(4, 2, 1, 1),
intArrayOf(3, 2, 1, 1)
)
 */

fun main() {
    val build_frame =
        arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(2, 0, 0, 1),
            intArrayOf(4, 0, 0, 1),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 1, 1, 1),
            intArrayOf(3, 1, 1, 1),
            intArrayOf(2, 0, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(2, 2, 0, 1),
            intArrayOf(0, 0, 0, 0)
        )
    solution(5, build_frame)
}

fun possible(answer: Set<Triple<Int, Int, Int>>): Boolean {
    for (stuff in answer) {
        val x = stuff.first
        val y = stuff.second
        val type = stuff.third
        return if (type == 0) {
            if (y == 0 || Triple(x - 1, y, 1) in answer || Triple(x, y, 1) in answer || Triple(x, y - 1, 0) in answer) {
                continue
            } else {
                false
            }
        } else {
            if (Triple(x, y - 1, 0) in answer || Triple(x + 1, y - 1, 0) in answer || (Triple(x - 1, y, 1) in answer && Triple(x + 1, y, 1) in answer)) {
                continue
            } else {
                false
            }
        }
    }
    return true
}

// 0 pillar, 1 floor
fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    val answer = mutableSetOf<Triple<Int,Int,Int>>()

    for (cmd in build_frame) {
        val stuff = Triple(cmd[0], cmd[1], cmd[2])

        if (cmd[3] == 0) {
            answer.remove(stuff)
            if (!possible(answer)) answer.add(stuff)
        } else {
            answer.add(stuff)
            if (!possible(answer)) answer.remove(stuff)
        }
        for(el in answer){ print("$el ")}
        println()
    }

    return answer.toList().sortedWith(compareBy ({ it.first }, {it.second}, {it.third} )).map {it.toList().toIntArray()}.toTypedArray()
}

fun solutionFail(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    val pillar = Array(n + 1) { IntArray(n + 1) { 0 } }
    val floor = Array(n + 1) { i -> IntArray(n + 1) { if (i == 0) 1 else 0 } }

    for (cmd in build_frame) {
        val x = cmd[0];
        val y = cmd[1];
        val type = cmd[2];
        val workType = cmd[3]
        if (type == 0) { // pillar
            if (workType == 1) { // build
                if ((x > 0 && floor[y][x - 1] == 1) || floor[y][x] == 1 || pillar[y - 1][x] == 1) pillar[y][x] = 1
            } else { // delete
                // 기둥이 삭제가 가능한 경우
                // 1. 기둥 양 옆으로 보가 하나도 없는 경우
                // 2. 기둥 양 옆에 모두 보가 있는 경우
                if (((x > 0 && floor[y + 1][x - 1] == 1) && floor[y + 1][x] == 1) || ((x > 0 && floor[y + 1][x - 1] == 0) && floor[y + 1][x] == 0)) {
                    pillar[y][x] = 0
                }
            }
        } else { // floor
            if (workType == 1) { // build
                if (pillar[y - 1][x] == 1 || pillar[y - 1][x + 1] == 1) floor[y][x] = 1
                else if ((x > 0 && floor[y][x - 1] == 1) && x < n && floor[y][x + 1] == 1) floor[y][x] = 1
            } else { // delete
                // 보가 삭제가 가능한 경우
                // 1. 보 양 옆에 있는 보 아래에 기둥이 하나라도 있는 경우 삭제가능
                // 2. 보 양 끝 모두 기둥이 위 아래로 한개 이상 존재하면 삭제가능
                if (pillar[y][x] == 0 && pillar[y][x + 1] == 0) {
                    var flag = 0
                    if ((x > 0 && floor[y][x - 1] == 1)) {
                        if (pillar[y - 1][x - 1] == 0 && pillar[y - 1][x] == 0) {
                            flag = 1
                        }
                    }
                    if (x < n && floor[y][x + 1] == 1) {
                        if (pillar[y - 1][x + 1] == 0 && pillar[y - 1][x + 2] == 0) {
                            flag = 1
                        }
                    }
                    if (flag == 0) {
                        floor[y][x] = 0
                    }
                }
                if (y < n) {
                    if ((pillar[y + 1][x] == 1 || pillar[y - 1][x] == 1) && (pillar[y + 1][x + 1] == 1 || pillar[y - 1][x + 1] == 1)) {
                        floor[y][x] = 0
                    }
                }
            }
        }
    }
    val answer = mutableListOf<IntArray>()
    for (i in 0..n) {
        for (j in 0..n) {
            if (pillar[j][i] == 1) answer.add(intArrayOf(i, j, 0))
            if (j > 0 && floor[j][i] == 1) answer.add(intArrayOf(i, j, 1))
        }
    }

    return answer.toTypedArray()
}