package question_type.dp

fun main() {
    val (n, target) = readLine()!!.split(" ").map { it.toInt() }
    val moneys = (0 until n).map { readLine()!!.toInt() }
    val dp = IntArray(target + 1) { Int.MAX_VALUE }

    dp[0] = 0
    for (i in 1..target) {
        for (money in moneys) {
            if (money <= i && dp[i - money] != -1) {
                dp[i] = minOf(dp[i - money] + 1, dp[i])
            }
        }
        if (dp[i] == Int.MAX_VALUE) dp[i] = -1
    }
    println(dp[target])
}