package programmers.level3

import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/43162

val networks = mutableSetOf<Set<Int>>()
val belongsToNetwork = mutableListOf<Int>()

fun addComputerToNetwork(computers: Array<IntArray>, nodeIdx: Int, network: SortedSet<Int>, n: Int) {
    val queue = mutableListOf<Int>()
    for ((idx, el) in computers[nodeIdx].withIndex()) {
        if(idx in belongsToNetwork) continue
        if (nodeIdx != idx && el == 1) queue.add(idx)
    }

    for (i in queue) {
        network.add(i)
        belongsToNetwork.add(i)
        addComputerToNetwork(computers, i, network, n)
    }
}

fun solution(n: Int, computers: Array<IntArray>): Int{
    for (i in 0 until n) {
        if(i in belongsToNetwork) continue
        val network = sortedSetOf<Int>()
        network.add(i)
        belongsToNetwork.add(i)
        addComputerToNetwork(computers, i, network, n)
        if (network.isNotEmpty()) networks.add(network)
    }
    return networks.size
}

fun main() {
    val n = 3
    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))
    println(solution(n, computers))
}