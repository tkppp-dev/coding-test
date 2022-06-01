package question_type.string

/**
 * 실행 속도는 확실히 라이브러리 사용하면 더 느리
 * split 은 빈 문자열도 쪼개서 넣어버림에 유의
 */

import java.util.*
/*
fun main(){
    val st = StringTokenizer(System.`in`.bufferedReader().readLine())
    with(System.out.bufferedWriter()){
        write("${st.countTokens()}")
        flush()
        close()
    }
}
*/
fun main() {
    val input = System.`in`.bufferedReader().readLine().trim()
    println(input.split(" "))
    with(System.out.bufferedWriter()){
        if(input.isEmpty()) write("0") else write("${input.split(" ").size}")
        flush()
        close()
    }
}