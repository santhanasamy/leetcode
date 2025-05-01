package leet

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val input = "$x".toCharArray()

        if (input.isEmpty()) {
            return false
        } else if (input.size == 1) {
            return true
        } else if (input.size == 2) {
            return input[0] == input[1]
        }
        var p1 = 0
        var p2 = 0
        if (input.size.rem(2) == 0) {
            p2 = input.size / 2
            p1 = p2 - 1
        } else {
            p2 = input.size / 2 + 1
            p1 = p2 - 2
        }

        while (p1 >= 0) {
            if (input[p1--] != input[p2++]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    PalindromeNumber().apply {
        require(isPalindrome(11)) { "[11] - Is Palindrome" }
        require(!isPalindrome(12)) { "[12] - Is Not Palindrome" }
        require(isPalindrome(121)) { "[121] - Is Palindrome" }
        require(isPalindrome(1221)) { "[1221] - Is Palindrome" }
        require(isPalindrome(1234321)) { "[1234321] - Is Palindrome" }
        require(!isPalindrome(120)) { "[120] - Is Not Palindrome" }
    }
}