package leet

class LongestPolindromSubString {
    fun longestPalindrome(s: String): String {

        s.toCharArray().forEachIndexed { index, c ->

        }
        return ""
    }
}

fun main() {

    LongestPolindromSubString().apply {
        println(longestPalindrome("babad"))
        println(longestPalindrome("babab"))
        println(longestPalindrome("cbbd"))
    }
}

