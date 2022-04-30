package question_type.greedy

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var repeatTime = 0
    var temp = n

    do {
        if (temp % k == 0) temp /= k
        else temp -= 1
        repeatTime++
    } while(temp > 1)

    println(repeatTime)
}
