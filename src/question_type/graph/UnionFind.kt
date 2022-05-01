package question_type.graph

/**
 * 유니온 파인드
 * 합집합과 파인드 연산을 반복하여 합집합을 만드는 알고리즘
 * 응용 : 사이클 확인이 가능 -> 집합 내 모든 노드끼리 합집합 연산 후 모든 노드의 부모가 같다면 사이클이 존재하는 것
 */

private lateinit var team: IntArray

fun main(){
    val (n,m) = readLine()!!.split(" ").map{ it.toInt() }
    team = IntArray(n+1){ it }

    repeat(m) {
        val (cmd, a, b) = readLine()!!.split(" ").map { it.toInt() }
        if(cmd == 0) union(a,b)
        else when(isSameTeam(a,b)){
            true -> println("YES")
            false -> println("NO")
        }
    }
}

fun find(a: Int): Int = if(team[a] != a) find(team[a]) else a

fun union(a: Int, b: Int){
    val teamA = find(a)
    val teamB = find(b)

    if(teamA < teamB) team[teamB] = teamA else team[teamA] = teamB
}

fun isSameTeam(a: Int, b: Int) = find(a) == find(b)
