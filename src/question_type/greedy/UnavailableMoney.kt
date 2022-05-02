package question_type.greedy

/**
 * 시작시간 12:10
 * 끝난시간 INF
 *
 * 소팅해서 1부터 만들수 있는지 확인하는 아이디어는 떠올렸으나
 * 만들수 있는지 를 확인하는 알고리즘을 구현하지 못해 못품
 * 그리디지만 dp의 느낌이 있음
 * 현재 원소에서 target 전까지, 즉 0 until target 법위의 수는 만들 수 있으니 (0 until target).map { it + el } 하면 target 부터 target + 현재 원소 - 1 까지의 범위의 수를 만들 수 잇는 것
 * 하지만 target 보다 현재 원소가 크다면 만들 수 있는 가장 작은 수인 현재 원소이므로 만들 수 없음
 *
 * 해설
 * list = [1, 1, 2, 3, 9]
 * target => 해당 수를 만들 수 있는가
 * target = 1 -> 첫 원소가 target 보다 크다면 만들 수 없음 그렇지 않다면 target 에 첫 원소를 더해줌
 * target = 2 -> 2 < 1 = false -> target = 3
 * target = 3 -> 3 < 2 = false -> target = 5
 * target = 5 -> 5 < 3 = false -> target = 8
 * target = 8 -> 8 < 9 = true -> break
 *
 */
fun main(){
    val n = readLine()!!.toInt()
    val inputs = readLine()!!.split(" ").map { it.toInt() }.sorted()

    var target = 1
    for(input in inputs){
        if(input > target) break
        target += input
    }
    println(target)
}