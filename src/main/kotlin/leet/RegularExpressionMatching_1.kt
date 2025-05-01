package leet

import java.util.ArrayDeque

class RegularExpressionMatching_1 {
    fun isMatch(inputStr: String, patternStr: String): Boolean {
        if (patternStr == ".*") {
            return true
        }
        val inputStack = ArrayDeque<Char>()
        val symbolStack = ArrayDeque<Char>()

        inputStr.forEach {
            inputStack.push(it)
        }
        patternStr.forEach {
            symbolStack.push(it)
        }


        var s: Char?
        var i: Char?

        while (symbolStack.isNotEmpty()) {
            s = symbolStack.pop()
            i = inputStack.peek()?.let { inputStack.pop() }
            if (s == '*') {
                val pre = symbolStack.pop()
                if (i != null && i != pre) {
                    inputStack.push(i)
                } else {
                    while (i == pre) {
                        i = inputStack.peek().takeIf { it == pre }?.let { inputStack.pop() }
                    }
                }
            } else if (s == '.') {
                // Do Nothing.
            } else if (i != null && s != i) {
                return false
            } else if (i == null && s != null) {
                return false
            } else {
                // Equal
            }
        }
        return inputStack.isEmpty() && symbolStack.isEmpty()
    }
}

fun main() {
    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.
    // .*" means "zero or more (*) of any character (.)
    RegularExpressionMatching_1().apply {
//        require(!isMatch("aa", "a")) { "aa => a No Match" }
//        require(isMatch("aa", "a*")) { "aa => a* Match" }
//        require(isMatch("ab", ".*")) { "aa => a* Match" }
//        require(isMatch("aab", "c*a*b")) { "aab => c*a*b Match" }
//        require(!isMatch("aaa", "ab*a")) { "aaa => ab*a No Match" }
//        require(!isMatch("mississippi", "mis*is*p*.")) { "mississippi => mis*is*p*. No Match" }
//        require(isMatch("mississippi", "mis*is*ip*.")) { "mississippi => mis*is*ip*. Match" }
//
//        require(isMatch("aaa", "ab*ac*a")) { "aaa => ab*ac*a Match" }
//        require(isMatch("aaa", "ab*a*c*a")) { "aaa => ab*ac*a Match" }
        require(!isMatch("aaa", "aaaa")) { "aaa => aaaa No Match" }
    }
}