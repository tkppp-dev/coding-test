package question_type.string

fun main(){
    val input = readLine()!!.uppercase().groupBy { it }
    val max = input.maxByOrNull { it.value.size }!!
    var count = 0

    for(word in input) {
        if(word.value.size == max.value.size) count++
        if(count > 2) break
    }
    if(count == 1) println(max.key) else println("?")
}