package leet

import kotlin.math.max

/**
 *  Longest Substring Without Repeating Characters
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        return when {
            s.isNullOrEmpty() -> {
                0
            }
            s.length == 1 -> {
                1
            }
            s.length == 2 -> {
                s.toCharArray().let {
                    if (it[0] == it[1]) {
                        1
                    } else {
                        2
                    }
                }
            }
            else -> {
                lss(s.toCharArray())
            }
        }
    }

    private fun lss(input: CharArray): Int {

        val set = linkedSetOf<Char>()
        var maxLength = 0
        var startIdx = 0
        var currentIdx = 0
        var current: Char

        while (currentIdx < input.size) {
            println("[${set.joinToString(",")}] [$startIdx, $currentIdx]")
            current = input[currentIdx]
            if (set.contains(current)) {
                maxLength = max(maxLength, set.size)
                startIdx += set.indexOf(current) + 1
                set.clear()
                set.add(input[startIdx])
                currentIdx = startIdx + 1
            } else {
                set.add(current)
                currentIdx++
            }

        }

        return max(maxLength, set.size)
    }

}

fun main() {
    val obj = LongestSubString()
    val allPossible = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
    var tc1 = "$allPossible$allPossible abcdefghijklmnopqrstuvwxyzABCD"

//    println(obj.lengthOfLongestSubstring("au")) // The answer is "au", with the length of 1.
//    println(obj.lengthOfLongestSubstring("abcabcbb")) // The answer is "abc", with the length of 3.
//    println(obj.lengthOfLongestSubstring("bbbbb")) // The answer is "b", with the length of 1.
//    println(obj.lengthOfLongestSubstring("pwwkew")) // The answer is "wke", with the length of 3.
//    println(obj.lengthOfLongestSubstring("santhana")) // The answer is "b", with the length of 1.
//    println(obj.lengthOfLongestSubstring("goutham")) // The answer is "wke", with the length of 3.
    println(obj.lengthOfLongestSubstring("aab")) // The answer is "wke", with the length of 3.
}
