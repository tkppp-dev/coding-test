package question_type.greedy

fun main(){
    val n = readLine()!!.toInt()
    val inputs = IntArray(n){
        readLine()!!.split(" ").minOf { it }.toInt()
    }

    println(inputs.maxOf{ it })
}