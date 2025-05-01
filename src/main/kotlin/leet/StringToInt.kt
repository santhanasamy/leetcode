package leet

class StringToInt {
    fun myAtoi(s: String): Int {

        val input = s.trim().toMutableList()

        val isNegative = if (input.getOrNull(0) == '-') {
            input.removeAt(0)
            true
        } else {
            if (input.getOrNull(0) == '+') {
                input.removeAt(0)
            }
            false
        }

        var isStarted = false
        var result = ""
        run breaking@{
            input.forEach {
                if (isStarted) {
                    if (!it.isDigit()) {
                        return@breaking
                    }
                    result += it
                } else {
                    if (it != '0') {
                        if (!it.isDigit()) {
                            return@breaking
                        }
                        isStarted = true
                        result += it
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return 0
        }
        var placeValue: Long = 1
        var tResult: Long = 0

        run breaking1@{
            result.toCharArray().reversed().forEach {
                tResult += Integer.parseInt("$it") * placeValue
                placeValue *= 10

                if (tResult > Int.MAX_VALUE || tResult < Int.MIN_VALUE) {
                    return@breaking1
                }

                if (placeValue > Int.MAX_VALUE && it == '0') {
                    tResult = Int.MAX_VALUE.toLong() + 1
                    return@breaking1
                }
            }
        }


        if (isNegative) {
            tResult -= 2 * tResult
        }

        tResult = if (tResult > Int.MAX_VALUE) {
            Int.MAX_VALUE.toLong()
        } else if (tResult < Int.MIN_VALUE) {
            Int.MIN_VALUE.toLong()
        } else {
            tResult
        }
        // println("$s   =>  $result   => $isNegative  => $tResult")
        return tResult.toInt()
    }
}

fun main() {
    StringToInt().apply {

//        myAtoi("words and 987")
//
//        myAtoi("  12 ")
//        myAtoi("012")
//        myAtoi("0012")
//
//        myAtoi("  +12 ")
//        myAtoi("+012")
//        myAtoi("+0012")
//
//        myAtoi("  -12 ")
//        myAtoi("-012")
//        myAtoi("-0012")
//
//        myAtoi("1337c0d3")
//        myAtoi("0-1")
//
//
//        var longInput: Long = 1 + Int.MAX_VALUE.toLong()
//        myAtoi(longInput.toString())
//
//        longInput = -1 + Int.MIN_VALUE.toLong()
//        myAtoi(longInput.toString())

        require(myAtoi("-91283472332") == Int.MIN_VALUE) { print("Error") }

        require(
            myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459")
                    == Int.MAX_VALUE
        ) { print("Error") }
        require(
            myAtoi("2147483646") == 2147483646
        ) { print("Error") }
        require(
            myAtoi("21474836460") == Int.MAX_VALUE
        ) { print("Error") }
    }
}