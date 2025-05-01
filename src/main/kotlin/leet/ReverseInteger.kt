package leet

class ReverseInteger {

    fun reverse(x: Int): Int {
        var input = Math.abs(x)
        var placeValue: Long = 1
        val reversed = mutableListOf<Int>()

        while (input > 0) {
            reversed.add(input.rem(10))
            input /= 10
            if (input > 0) {
                placeValue *= 10
            }
        }

        var res: Long = 0
        reversed.forEach {
            res += it * placeValue
            placeValue /= 10
        }
        // Negative Number
        if (x < 0) {
            res -= (2 * res)
        }

        return if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) {
            0
        } else {
            res.toInt()
        }
    }
}

/**
 * -2^31 <= x <= 2^31 - 1
 */
fun main() {

    ReverseInteger().apply {

        println("${reverse(2147483647)}")
        println("${reverse(-123456)}")
    }
}