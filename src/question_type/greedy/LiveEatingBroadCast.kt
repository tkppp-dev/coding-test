package question_type.greedy

import java.util.*
import kotlin.math.max

/**
 * 1차
 * 시작시간 2:04
 * 끝난시간 2:42
 * 소요시간 38분
 *
 * 연결리스트를 활용해 풀었으나 효율성 테스트에서 개박살남 -> 다른 풀이 필요
 *
 * 2차
 * 시작시간 2:45
 * 끝난시간 3:20
 *
 * 풀다 머리 빠개져서 포기
 *
 * 3차 : 우선순위 큐
 * maxRotate 를 낀 풀이
 * maxRotate 보다 음식의 최솟값이 작거나 같다면 다 먹게되는 음식이 존재하지 않음
 * 그렇지 않다면 다 먹게되는 음식이 존재하므로 time - (heap.size * minValueOfFood)를 수행함으로서 minValueOfFood 만큼 회전한 것으로 간주하고 minValueOfFood 를 모두 poll 한다
 * 이것을 반복하면 k가 힙의 크기보다 작아지는 k를 얻을 수 있고 그 heap 을 정렬해서 k번째 Food 의 인덱스를 반환하면 그것이 답
 *
 * 자바의 우선순위 큐를 사용하지 않고 단순히 food_times 리스트를 내림차순으로 소팅해서 우선순위 큐처럼 사용해도 무방
 * 리스트를 사용할 경우 removeLast 를 통해 O(1) 의 시간복잡도를 가짐, but 공간복잡도는 높다
 * */


fun main() {
    val foodTimes = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val k = readLine()!!.toLong()
    println(solution(foodTimes, k))
}

fun solution(food_times: IntArray, k: Long): Int {
    data class Food(val n: Int, var value: Int) : Comparable<Food> {
        override fun compareTo(other: Food): Int {
            return this.value - other.value
        }
    }

    val heap = PriorityQueue<Food>()
    for (i in food_times.indices) heap.add(Food(i + 1, food_times[i]))

    var time = k; var prev = 0
    while (heap.size <= time) {
        val maxRotate = time / heap.size
        val food = heap.peek()
        if (food.value - prev <= maxRotate) {
            time -= (food.value - prev) * heap.size
            prev = food.value
            while (true) {
                val temp = heap.peek()?.value
                if (food.value == temp) {
                    heap.poll()
                    continue
                } else break
            }
            if(heap.isEmpty()) break
        } else time %= heap.size
    }

    return if (heap.isEmpty()) -1 else heap.toList().sortedBy { it.n }[time.toInt()].n
}

fun solution1st(food_times: IntArray, k: Long): Int {
    data class Food(val n: Int, var value: Int)

    val ll = LinkedList<Food>()
    for (i in food_times.indices) ll.add(Food(i + 1, food_times[i]))

    var time = 0
    var iter = ll.iterator()
    var flag = 0

    while (time < k) {
        val food = iter.next()
        food.value--
        if (food.value == 0) iter.remove()
        time++
        if (!iter.hasNext()) {
            if (ll.isEmpty()) {
                flag = 1
                break
            } else {
                iter = ll.iterator()
            }
        }
    }
    return if (flag == 0) iter.next().n else -1
}