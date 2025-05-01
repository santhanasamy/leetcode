package leet.common

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        //${left?.let { "$it<=" }}${`val`}${right?.let { "$it=>" }}
        return "$`val`"
    }
}

fun buildTree(arrayOfInts: IntArray): TreeNode? {
    val array: Array<Int?> = arrayOfInts.toTypedArray() as Array<Int?>
    return buildTree(array)
}

fun buildTree(arrayOfInts: Array<Int?>): TreeNode? {
    val length = arrayOfInts.size

    val root = if (length > 0) {
        arrayOfInts[0]?.let { TreeNode(it) }
    } else {
        null
    }
    root ?: return null

    if (length == 1) {
        return root
    }

    var idx = 0
    val stack = ArrayDeque<TreeNode>()
    stack.offer(root)

    while (!stack.isEmpty() && idx < arrayOfInts.size) {
        stack.pop().let {
            idx += 1
            it.left = if (idx < length) {
                arrayOfInts.getOrNull(idx)?.let { node ->
                    TreeNode(node)
                }
            } else null

            idx += 1
            it.right = if (idx < length) {
                arrayOfInts.getOrNull(idx)?.let { node ->
                    TreeNode(node)
                }
            } else null

            it.left?.let { n -> stack.addLast(n) }
            it.right?.let { n -> stack.addLast(n) }
        }
    }
    return root
}

fun main() {
    buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1))
}