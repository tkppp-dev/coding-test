package question_type.string

fun getTime(c: Char) = when(c){
    in 'A'..'C' -> 3
    in 'D'..'F' -> 4
    in 'G'..'I' -> 5
    in 'J'..'L' -> 6
    in 'M'..'O' -> 7
    in 'P'..'S' -> 8
    in 'T'..'V' -> 9
    else -> 10
}

fun main(){
    val input = System.`in`.bufferedReader().readLine()
    with(System.out.bufferedWriter()) {
        write("${input.fold(0) { sum, c -> sum + getTime(c) }}")
        flush()
        close()
    }
}