package leet.common

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "$`val` -> ${next?.toString()}"
    }
}

fun ListNode.next(no: Int): ListNode? {
    next = ListNode(no)
    return next
}


fun buildListNode(array: IntArray): ListNode? {
    var head: ListNode? = null
    var current: ListNode? = null

    array.forEach {
        if (head == null) {
            head = ListNode(it)
            current = head
        } else {
            current?.next = current?.next(it)
            current = current?.next
        }
    }
    return head
}