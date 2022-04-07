package programmers

fun solution(v: Array<IntArray>): IntArray {
    val answer = mutableListOf<Int>()
    v.groupBy { it[0] }.forEach() {
        if(it.value.size == 1) answer.add(it.key)
    }

    v.groupBy { it[1] }.forEach(){
        if(it.value.size == 1) answer.add(it.key)
    }

    return answer.toIntArray()
}

fun main(){
    val a = 3
    for(i in 0 until a) {
        for(j in 0 until i+1) {
            print("*")
        }
        println("")
    }
}