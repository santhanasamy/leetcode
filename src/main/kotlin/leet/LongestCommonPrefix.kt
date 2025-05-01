package leet

import kotlin.math.min

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {

        var minLen = Int.MAX_VALUE
        val map = mutableMapOf<Int, CharArray>().apply {
            strs.forEachIndexed { index, s ->
                val strToArray = s.toCharArray()
                minLen = min(minLen, strToArray.size)
                put(index, strToArray)
            }
        }

        var prefix = ""
        strs.forEachIndexed { index, s ->
            if (index > 0) {
                val cur = map[index]!!
                var tempPrefix = ""
                val curLen = min(min(cur.size, prefix.length), minLen)

                for (i in 0 until curLen) {
                    if (prefix[i] == cur[i]) {
                        if (tempPrefix.length > prefix.length) {
                            break
                        }
                        tempPrefix += cur[i]
                    } else {
                        break
                    }
                }
                prefix = tempPrefix
            } else {
                prefix = s
            }
        }
        return prefix
    }
}

fun main() {
    LongestCommonPrefix().apply {
        println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        println(longestCommonPrefix(arrayOf("dog","racecar","car")))
    }
}