package kakao.internship2021

/**
 * 시작시간 3:07
 *
 */

fun main() {
    solution(1, 0, arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"))
}

var max = 0

private class Row(
    val num: Int,
    var prev: Row? = null,
    var next: Row? = null
) {
    fun insert(next: Row): Row {
        val temp = this.next
        this.next = next
        next.prev = this
        next.next = temp
        return next
    }

    fun restoreNode(restore: Row) {
        val p = restore.prev
        val n = restore.next

        if(p != null) p.next = restore
        if(n != null) n.prev = restore
    }

    fun delete(): Row? {
        val temp = this.next

        temp?.prev = this.prev
        this.prev?.next = temp

        return temp ?: this.prev
    }

    fun up(n: Int): Row {
        var temp = this
        repeat(n) {
            if(temp.prev != null) {
                temp = temp.prev!!
            }
        }
        return temp
    }

    fun down(n: Int): Row {
        var temp = this
        repeat(n) {
            if(temp.next != null) {
                temp = temp.next!!
            }
        }
        return temp
    }
}

fun solution(n: Int, k: Int, cmd: Array<String>): String {
    var node = Row(0)
    var cnode: Row = node
    val stack = arrayListOf<Row>()

    max = n

    repeat(n - 1) {
        node = node.insert(Row(it + 1))
        if (it + 1 == k) {
            cnode = node
        }
    }

    for (_cmd in cmd) {
        val cmdTemp = _cmd.split(" ")
        when (cmdTemp[0]) {
            "U" -> {
                val repeat = cmdTemp[1].toInt()
                cnode = cnode.up(repeat)
            }
            "D" -> {
                val repeat = cmdTemp[1].toInt()
                cnode = cnode.down(repeat)
            }
            "C" -> {
                stack.add(cnode)
                val temp = cnode.delete()
                if(temp != null) cnode = temp
            }
            else -> {
                val pop = stack.removeLast()
                cnode.restoreNode(pop)
            }
        }
    }

    val answer = Array(n) { "X" }
    var temp: Row? = cnode

    while(temp != null){
        answer[temp.num] = "O"
        temp = temp.prev
    }

    temp = cnode
    while(temp != null){
        answer[temp.num] = "O"
        temp = temp.next
    }

    return answer.joinToString("")
}