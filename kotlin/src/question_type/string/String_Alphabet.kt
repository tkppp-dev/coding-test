package question_type.string

fun main(){
    val input = readLine()!!
    println("abcdefghijklmnopqrstuvwxyz".map {input.indexOf(it)}.joinToString(" "))
}