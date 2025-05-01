package leet

import leet.common.TreeNode
import leet.common.buildTree
import java.util.Stack

class KthLargestSumInTree {

    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {

        val list = mutableListOf<Long>()
        val stack = Stack<TreeNode?>().apply {
            push(root)
        }

        while (stack.isNotEmpty()) {
            var sum: Long = 0
            val localChild = mutableListOf<TreeNode?>()
            while (stack.isNotEmpty()) {
                sum += stack.pop()?.let {
                    it.left?.let { localChild.add(it) }
                    it.right?.let { localChild.add(it) }
                    it.`val`
                } ?: 0
            }
            list.add(sum)
            localChild.forEach {
                stack.push(it)
            }
        }
        return list.sorted().reversed().getOrElse(k - 1) { -1 }
    }

}

fun main() {
    KthLargestSumInTree().apply {
        var input: TreeNode? = buildTree(intArrayOf(5, 8, 9, 2, 1, 3, 7, 4, 6))
        println("$input => ${kthLargestLevelSum(input, 2)}")

        input = buildTree(arrayOf(1, 2, null, 3))
        println("$input => ${kthLargestLevelSum(input, 1)}")
    }
}