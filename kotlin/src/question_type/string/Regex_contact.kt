package question_type.string

/**
 * 문제 : https://www.acmicpc.net/problem/1013
 * 만약 코딩테스트에서 입출력을 직접 수행해야한다면 bufferedReader, Writer 를 이용하는게 수행시간에 영향을 미칠 수 있다.
 * 프로그래머스 같은 방식이면 필요 없음
 */

fun main(){
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val n = reader.readLine()!!.toInt()
    val regex = Regex("((100+1+)|(01))+")

    (0 until n).map {
        val pattern = reader.readLine()!!
        when(regex.matches(pattern)){
            true -> writer.append("YES")
            false -> writer.append("NO")
        }
        writer.append("\n")
    }

    writer.flush()
    writer.close()
}

fun firstTry(){
    val n = readLine()!!.toInt()
    val regex = Regex("((100+1+)|(01))+")

    (0 until n).map {
        val pattern = readLine()!!
        when(regex.matches(pattern)){
            true -> println("YES")
            false -> println("NO")
        }
    }
}
