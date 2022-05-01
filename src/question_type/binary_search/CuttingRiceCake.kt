package question_type.binary_search

/**
 * 이진 탐색은 탐색해야 하는 범위가 매우 클 경우 의심해볼수 있다
 * 이진 탐색을 위해서는 정령되엉 있어야함
 */

private lateinit var inputs: List<Int>

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    inputs = readLine()!!.split(" ").map { it.toInt() }.sorted()

    println(binarySearch(0, inputs.last(), m))
}

fun binarySearch(start: Int, end: Int, target: Int): Int {
    val cutterLength = (start + end) / 2
    val riceCakeLength = inputs.fold(0) { total, next ->
        val length = next - cutterLength
        total + if (length < 0) 0 else length
    }

    return if (target == riceCakeLength) cutterLength
    else if (target > riceCakeLength) binarySearch(start, cutterLength - 1, target)
    else binarySearch(cutterLength + 1, end, target)
}
