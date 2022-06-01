package programmers.level2

data class Progress(
    var progresses: Int,
    var speed: Int,
    var completed: Boolean = false
)

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val answer = mutableListOf<Int>()
    val progressList = mutableListOf<Progress>()

    for((idx, el) in progresses.withIndex()){
        progressList.add(Progress(
            el, speeds[idx]
        ))
    }

    while(progressList.isNotEmpty()){
        progressList.forEach {
            it.progresses += it.speed
            if(it.progresses >= 100) it.completed = true
        }

        var completed = 0
        for(progress in progressList){
            if(progress.completed) completed ++
            else break
        }

        for(i in 0 until completed){
            progressList.removeAt(0)
        }

        if(completed > 0) answer.add(completed)
    }

    return answer.toIntArray()
}