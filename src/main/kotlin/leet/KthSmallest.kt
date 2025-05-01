package leet

import leet.common.TreeNode

class KthSmallest {
    var x = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {

        root?.left?.let {kthSmallest(it, k)}

        root?.let { x +=1 }

        if(x == k) {
            return root?.`val` ?: -1
        }
        root?.right?.let {kthSmallest(it, k)}
        return -1
    }
}