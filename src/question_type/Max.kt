package question_type

data class Value(
    val value: Int
)
fun main(){
    val list = List(1000){
        Value((1..1000).random())
    }

    val maxOf = list.maxOf { it.value }
    val maxBy = list.maxByOrNull { it.value }

    println("$maxOf $maxBy")
}