package programmers.level3

var targetWord = ""
var listLength = 0
var answer = Int.MAX_VALUE

fun getConvertableWords(currentWord: String, words: Array<String>) =
    words.filter {
        var isNotSame = 0;
        for((idx, c) in it.withIndex()){
            if(c != currentWord[idx]){
                isNotSame++
                if(isNotSame > 1) break
            }
        }
        return@filter isNotSame == 1
    }

fun removeElementAtArray(arr: Array<String>, target: String): Array<String> {
    val list = arr.toMutableList()
    list.remove(target)
    return list.toTypedArray()
}

fun convertWord(begin: String, remains: Array<String>) {
    val convertibleWords = getConvertableWords(begin, remains)
    if(convertibleWords.isEmpty()) {
        return
    }

    convertibleWords.forEach {
        if(it == targetWord) {
            if(listLength - remains.size + 1 < answer) answer = listLength - remains.size + 1
            return
        }
        val remainArr = removeElementAtArray(remains, it)
        convertWord(it, remainArr)
    }
}

fun solution(begin: String, target: String, words: Array<String>): Int {
    targetWord = target
    listLength = words.size

    convertWord(begin, words)

    return if(answer != Int.MAX_VALUE) answer else 0
}

fun main(){
    val begin = "hit"
    val target = "cog"
    val words = arrayOf("hot", "dot", "dog", "lot", "log", "cog")
    println(solution(begin, target, words))
}