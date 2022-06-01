package question_type.string

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var ans = 0;

    repeat(n) {
        val input = br.readLine()
        val set = mutableSetOf<Char>()
        var prev: Char? = null
        var flag = 0

        for(c in input) {
            if(c == prev) continue
            else {
                if(c !in set){
                    set.add(c)
                    prev = c
                }
                else{
                    flag = 1
                    break
                }
            }
        }
        if(flag == 0) ans++
    }
    with(System.out.bufferedWriter()){
        write("$ans")
        flush()
        close()
    }
}

fun useLibrary() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var ans = 0;

    repeat(n) {
        val input = br.readLine()
        var prev: Char? = null
        val max = input.filter{
            if(it == prev) false
            else {
                prev = it
                true
            }
        }.groupBy { it }.maxByOrNull { it.value.size }!!.value.size
        if(max == 1) ans++
    }
    with(System.out.bufferedWriter()){
        write("$ans")
        flush()
        close()
    }
}