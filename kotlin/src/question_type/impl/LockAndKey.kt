package question_type.impl

/**
 * 시작시간 6:12
 * 끝난시간 7:51
 *
 * 1차 중단 -> 접근법이 잘못됨을 깨달음
 * 2차 중단 -> 도저히 안될거 같아 답 봄
 *
 * 재시작시간 8:55
 * 끝낸시간 8:34
 * 구현시간 39분
 *
 * 오답 노트
 * 완전 탐색 유형의 풀이었으나 너무 복잡하게 생각하고 쉽게 풀려다 망한 문제
 */

fun main() {
    val key = (0 until 3).map {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }.toTypedArray()

    val lock = (0 until 3).map {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }.toTypedArray()

    println(solution(key, lock))
}

private var n: Int = 0
private var m: Int = 0

fun reset(lock: Array<IntArray>, extLock: Array<IntArray>) {
    for (i in 0 until m) {
        for (j in 0 until m) {
            extLock[i + n - 1][j + n - 1] = lock[i][j]
        }
    }
}

fun unlock(extLock: Array<IntArray>, key: Array<IntArray>, x: Int, y: Int): Boolean {
    for (i in key.indices) {
        for (j in key.indices) {
            extLock[i + x][j + y] += key[i][j]
        }
    }
    for (i in 0 until m) {
        for (j in 0 until m) {
            if (extLock[i + n - 1][j + n - 1] != 1) return true
        }
    }
    return false
}

fun rotateKey(key: Array<IntArray>): Array<IntArray> = Array(key.size) { i -> IntArray(key.size) { j -> key[n - j - 1][i] } }

fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    n = key.size
    m = lock.size
    val extLock = Array(m + 2 * (n - 1)) { IntArray(m + 2 * (n - 1)) { 0 } }
    reset(lock, extLock)

    var rotateKey = key
    for(i in 0 until 4){
        for (x in 0 until n + m - 1) {
            for (y in 0 until n + m - 1){
                if(unlock(extLock, rotateKey, x, y)) return true
                reset(lock, extLock)
            }
        }
        rotateKey = rotateKey(rotateKey)
    }
    return false
}