package leet

import leet.common.ListNode
import leet.common.buildListNode

class MergeKLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        val list = mutableListOf<ListNode>()
        lists.forEach {
            var tHead = it
            while (tHead != null) {
                list.add(tHead)
                tHead = tHead.next
            }
        }
        list.sortBy {
            it.`val`
        }

        for (i in 0 until list.size - 1) {
            list[i].next = list[i + 1]
        }
        return if(list.isEmpty()) null else list[0]
    }
}

fun main() {
    MergeKLists().apply {
        var input = arrayOf(
            buildListNode(intArrayOf(1, 4, 5)),
            buildListNode(intArrayOf(1, 3, 4)),
            buildListNode(intArrayOf(2, 6))
        )
        println(mergeKLists(input))
    }
}
