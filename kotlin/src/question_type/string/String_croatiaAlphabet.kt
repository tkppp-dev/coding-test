package question_type.string

fun main() {
    val input = System.`in`.bufferedReader().readLine()
    var count = 0

    for ((i, c) in input.withIndex()) {
        if (c == '=') {
            if (input[i - 1] == 'z' && i - 2 >= 0 && input[i - 2] == 'd') {
                count += 2
            } else {
                count++
            }
        } else if (c == '-') {
            count++
        } else if (c == 'j') {
            if (i > 0 && (input[i-1] == 'l' || input[i-1] == 'n')) {
                count++
            }
        }
    }

    with(System.out.bufferedWriter()) {
        write("${input.length - count}")
        flush()
        close()
    }
}