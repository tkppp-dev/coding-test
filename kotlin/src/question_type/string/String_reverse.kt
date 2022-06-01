package question_type.string

fun main() {
    val (n1, n2) = System.`in`.bufferedReader().readLine().split(" ")
    val r1 = n1.reversed(); val r2 = n2.reversed()
    with(System.out.bufferedWriter()){
        if(r1 > r2) write("$r1") else write("$r2")
        flush()
        close()
    }
}