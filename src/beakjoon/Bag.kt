package beakjoon

// https://www.acmicpc.net/problem/12865
// 1차 시작시간 2:58 종료시간 3:51

/**
6 13
4 8
3 6
5 12
 */

var mw: Int = 0
var things: List<IntArray> = listOf()

fun getMax(index: Int, w: Int, v: Int, results: MutableList<Int>) {
    if(index == things.size - 1) {
        results.add(v)
        return
    }
    else {
       for(i in index+1 until things.size){
           if(w + things[i][0] > mw){
               results.add(v)
               continue
           } else getMax(i, w + things[i][0], v + things[i][1], results)
       }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, maxWeight) = br.readLine().split(" ").map { it.toInt() }

    mw = maxWeight
    things = (0 until n).map {
        val (w, v) = br.readLine().split(" ")
        intArrayOf(w.toInt(), v.toInt())
    }.groupBy { it[0] }.map {group ->
        intArrayOf(group.key, group.value.maxOf { it[1] } )
    }

    var max = 0

    for(i in things.indices){
        val results = mutableListOf<Int>()
        getMax(i, things[i][0], things[i][1], results)
        val temp = results.maxOf { it }
        if(max < temp) max = temp
    }

    with(System.out.bufferedWriter()){
        write("$max")
        flush()
        close()
    }
}