package leet

import java.util.ArrayDeque

class ValidateParentheses {
    fun isValid(s: String): Boolean {
        val map = mapOf('[' to ']', '{' to '}', '(' to ')')


        val stack = ArrayDeque<Char>()
        s.forEach {
            if (it == '[' || it == '{' || it == '(') {
                stack.push(it)
            } else {
                if (it == map[stack.peek()]) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    ValidateParentheses().apply {
        println(isValid("[]"))
        println(isValid("()[]{}"))
        println(isValid("([])"))
        println(isValid("(]"))


    }
}