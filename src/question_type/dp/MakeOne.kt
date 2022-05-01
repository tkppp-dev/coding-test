package question_type.dp

// dp를 의심해볼 경우 -> 정공법으로는 완전탐색 but 시간 복잡도가 오질라게 높아지는 경우
// 방법이 아리송 하면 바텀업 방식 dp 생각

fun main(){
    val n = readLine()!!.toInt()
    val dp = IntArray(n + 1) { 0 }

    for(i in 2..n){
        dp[i] = dp[i-1] + 1
        if(i%2 == 0) dp[i] = minOf(dp[i], dp[i/2] + 1)
        if(i%3 == 0) dp[i] = minOf(dp[i], dp[i/3] + 1)
        if(i%5 == 0) dp[i] = minOf(dp[i], dp[i/5] + 1)
    }
    println(dp[n])
}