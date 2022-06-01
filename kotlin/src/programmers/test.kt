package programmers

fun test(): Int{
    for(i in 0..2){
        for(j in 3..5){
            if(j == 4) return 4
        }
    }
    return 0
}

fun main(){
    println(test())
}