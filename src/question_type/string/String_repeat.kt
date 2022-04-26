package question_type.string

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        val input = readLine()!!.split(" ")
        val answer = StringBuilder()
        input[1].forEach { c -> repeat(input[0].toInt()) { answer.append(c) } }
        println(answer.toString())
    }
}