package programmers

import kotlin.text.StringBuilder

/**
 * "this is {template} {template} is {state}"	[["template", "string"], ["state", "changed"]]	"this is string string is changed"
"this is {template} {template} is {state}"	[["template", "string"], ["state", "{template}"]]	"this is string string is string"
"this is {template} {template} is {state}"	[["template", "{state}"], ["state", "{template}"]]	"this is {template} {template} is {state}"
"this is {template} {template} is {state}"	[["template", "{state}"], ["state", "{templates}"]]	"this is {templates} {templates} is {templates}"
"{a} {b} {c} {d} {i}"	[["b", "{c}"], ["a", "{b}"], ["e", "{f}"], ["h", "i"], ["d", "{e}"], ["f", "{d}"], ["c", "d"]]	"d d d {d} {i}"
 */

/**
 * 오답 노트
 * 1. 문자열을 치환해야되는데 그게 단어 단위라면 문자열을 쪼개서 배열로 만들고 치환한다음 다시 합치는 방법을 고려하자 - for 문으로 돌려서 replace 할 경우 치환된 부분이 다시 치환될 가능성이 있다.
 * 2. 무식하게 안되는거 먼저 찾아서 없애고 시작할려고만 하지말고 하다가 안되는걸 찾는 것도 고려하자
 */

data class Template(
    val template: String,
    val value: String,
)

fun solution(tstring: String, variables: Array<Array<String>>): String{
    val templateMap = variables.map { Template("{${it[0]}}", it[1]) }.groupBy { it.template }
    val answerSet = mutableSetOf<String>()
    val chunks = tstring.split(" ").toTypedArray()

    var answer = chunks.joinToString(" ")
    while(answer !in answerSet){
        answerSet.add(answer)
        for(idx in chunks.indices) {
            val key = chunks[idx]
            if(templateMap.containsKey(key)) chunks[idx] = templateMap[key]!![0].value
        }
        answer = chunks.joinToString(" ")
    }

    return answer
}

fun main() {
    val tstring = "{a} {b} {c} {d} {i}"
    val variables =
        arrayOf(
            arrayOf("b", "{c}"),
            arrayOf("a", "{b}"),
            arrayOf("e", "{f}"),
            arrayOf("h", "i"),
            arrayOf("d", "{e}"),
            arrayOf("f", "{d}"),
            arrayOf("c", "d")
        )

    val tstring2 = "this is {template} {template} is {state}"
    val variables2 = arrayOf(arrayOf("template", "string"), arrayOf("state", "changed"))
    println(solution(tstring2, variables2))
}