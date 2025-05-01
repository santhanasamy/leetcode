package leet

import leet.common.ListNode
import leet.common.buildListNode

class MergeSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var i = list1
        var j = list2
        val resultList = mutableListOf<ListNode>()
        while (i != null || j != null) {
            if (i != null && j != null) {
                if (i.`val` <= j.`val`) {
                    resultList.add(i)
                    i = i.next
                } else {
                    resultList.add(j)
                    j = j.next
                }
            } else if (i == null) {
                while (j != null) {
                    resultList.add(j)
                    j = j.next
                }
            } else if (j == null) {
                while (i != null) {
                    resultList.add(i)
                    i = i.next
                }
            }
        }

        if(resultList.isEmpty()) {
            return null
        }
        val resSize = resultList.size
        for (k in 0 until resSize) {
            resultList[k].next = if (k + 1 < resSize) resultList[k + 1] else null
        }
        return resultList[0]
    }
}

fun main() {
    MergeSortedList().apply {
        println(mergeTwoLists(buildListNode(intArrayOf(1, 2, 4)), buildListNode(intArrayOf(1, 3, 4))))
    }
}