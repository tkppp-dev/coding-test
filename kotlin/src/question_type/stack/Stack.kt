package question_type.stack

import java.util.*
import kotlin.system.measureNanoTime

fun main() {
    val repetitions = 10000000
    val stack1 = Stack<Int>()
    val stack2 = mutableListOf<Int>()
    val stack3 = arrayListOf<Int>()

    val pushTime1 = measureNanoTime { repeat(repetitions) { stack1.push(it) } }
    val pushTime2 = measureNanoTime { repeat(repetitions) { stack2.add(it) } }
    val pushTime3 = measureNanoTime { repeat(repetitions) { stack3.add(it) } }
    val mid1 = listOf(pushTime1, pushTime2, pushTime3).sorted()[1]

    println("${pushTime1 - mid1} ${pushTime2 - mid1} ${pushTime3 - mid1}")

    val popTime1 = measureNanoTime { repeat(repetitions) { stack1.pop() } }
    val popTime2 = measureNanoTime { repeat(repetitions) { stack2.removeLast() } }
    val popTime3 = measureNanoTime { repeat(repetitions) { stack3.removeLast() } }
    val mid2 = listOf(popTime1, popTime2, popTime3).sorted()[1]

    println("${popTime1 - mid2} ${popTime2 - mid2} ${popTime3 - mid2}")
}