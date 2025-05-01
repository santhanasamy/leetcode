package leet

import leet.common.ListNode
import leet.common.buildListNode
import java.math.BigInteger

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    private val placeValMultiplier: BigInteger = BigInteger.valueOf(10)

    private fun buildNumber(headNode: ListNode?): BigInteger {
        var node = headNode
        var placeValue = BigInteger.valueOf(1)
        var finalNumber = BigInteger.valueOf(0)
        while (node != null) {
            finalNumber = finalNumber.add(placeValue.multiply(BigInteger.valueOf(node.`val`.toLong())))
            placeValue = placeValue.multiply(placeValMultiplier)
            node = node.next
        }
        return finalNumber
    }

    private fun buildListNode(inputNo: BigInteger?): ListNode {

        inputNo ?: return ListNode(0)

        var head: ListNode? = null
        var current: ListNode? = null

        inputNo.toString().reversed().forEach {
            if (head == null) {
                head = ListNode("$it".toInt())
                current = head
            } else {
                current?.next = ListNode("$it".toInt())
                current = current?.next
            }
        }
        return head ?: ListNode(0)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        val noOne = buildNumber(l1)
        println("Input 1 [$noOne]")

        val noTwo = buildNumber(l2)
        println("Input 2 [$noTwo]")

        val resNo: BigInteger? = noTwo.add(noOne) // 807
        println("Result  [$resNo]")

        val resNode: ListNode = buildListNode(resNo)
        println("Result  [$resNode]")

        return resNode
    }
}

fun main() {

//    val l1 = ListNode(2).apply {
//        this.next = ListNode(4).apply {
//            this.next = ListNode(3)
//        }
//    }
//    val l2 = ListNode(5).apply {
//        this.next = ListNode(6).apply {
//            this.next = ListNode(4)
//        }
//    }

//    Solution().addTwoNumbers(l1, l2)


    // val l1 = ListNode(9)
    // val l2 = ListNode(1)
    //l2.next(9)?.next(9)?.next(9)?.next(9)?.next(9)?.next(9)?.next(9)?.next(9)?.next(9)

    val l1 = buildListNode(intArrayOf(5, 6, 4))
    val l2 = buildListNode(intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1))
    Solution().addTwoNumbers(l1, l2)

}