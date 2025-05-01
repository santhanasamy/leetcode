package leet

import leet.common.ListNode
import leet.common.buildListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        if (head == null) {
            return null
        }
        var tHead: ListNode? = head
        var i = 1
        while (tHead?.next != null) {
            i++
            tHead = tHead.next
        }

        var j = 1
        val t = i - n + 1
        tHead = head

        return if (i == 1 && n == 1) {
            null
        } else if (i > 1 && t == 1) {
            tHead.next
        } else {
            while (tHead?.next != null) {
                j++
                if (j == t) {
                    tHead.next = tHead.next?.next
                    break
                } else {
                    tHead = tHead.next
                }
            }
            head
        }
    }
}

fun main() {


    RemoveNthNode().apply {

        var input = buildListNode(intArrayOf(1, 2, 3, 4, 5))
        println(removeNthFromEnd(input, 2))  // [1,2,3,5]

        input = buildListNode(intArrayOf(1))
        println(removeNthFromEnd(input, 1)) //  []

        input = buildListNode(intArrayOf(1, 2))
        println(removeNthFromEnd(input, 1)) // [1]

        input = buildListNode(intArrayOf(1, 2))
        println(removeNthFromEnd(input, 2)) // [2]
    }
}