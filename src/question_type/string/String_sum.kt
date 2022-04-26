package question_type.string

fun main(){
    readLine()
    println(readLine()!!.fold(0) { sum, c -> sum + c.toString().toInt() })
}