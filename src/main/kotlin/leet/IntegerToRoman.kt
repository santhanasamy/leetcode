package leet

class IntegerToRoman {
//    I	1
//    V	5
//    X	10
//    L	50
//    C	100
//    D	500
//    M	1000
//  4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD), 900 (CM).

    fun intToRoman(num: Int): String {
        val map = mutableMapOf(
            (1 to "I"),
            (4 to "IV"),
            (5 to "V"),
            (9 to "IX"),
            (10 to "X"),
            (40 to "XL"),
            (50 to "L"),
            (90 to "XC"),
            (100 to "C"),
            (400 to "CD"),
            (500 to "D"),
            (900 to "CM"),
            (1000 to "M")
        )

        var res = ""
        var tempNo = num
        if (tempNo >= 1000) {
            val thousands = tempNo / 1000
            for (i in 1..thousands) {
                res += map[1000]
            }
            tempNo = tempNo.rem(1000)
        }

        if (tempNo >= 900) {
            res += map[900]
            tempNo = tempNo.rem(900)
        }
        if (tempNo >= 500) {
            val fiveHundreds = tempNo / 500
            for (i in 1..fiveHundreds) {
                res += map[500]
            }
            tempNo = tempNo.rem(500)
        }
        if (tempNo >= 400) {
            res += map[400]
            tempNo = tempNo.rem(400)
        }

        if (tempNo >= 100) {
            val hundreds = tempNo / 100
            for (i in 1..hundreds) {
                res += map[100]
            }
            tempNo = tempNo.rem(100)
        }
        if (tempNo >= 90) {
            res += map[90]
            tempNo = tempNo.rem(90)
        }

        if (tempNo >= 50) {
            val fifties = tempNo / 50
            for (i in 1..fifties) {
                res += map[50]
            }
            tempNo = tempNo.rem(50)
        }
        if (tempNo >= 40) {
            res += map[40]
            tempNo = tempNo.rem(40)
        }
        if (tempNo >= 10) {
            val tens = tempNo / 10
            for (i in 1..tens) {
                res += map[10]
            }
            tempNo = tempNo.rem(10)
        }
        if (tempNo >= 9) {
            res += map[9]
            tempNo = tempNo.rem(9)
        }
        if (tempNo >= 5) {
            val fives = tempNo / 5
            for (i in 1..fives) {
                res += map[5]
            }
            tempNo = tempNo.rem(5)
        }
        if (tempNo >= 4) {
            res += map[4]
            tempNo = tempNo.rem(4)
        }

        if (tempNo >= 1) {
            val ones = tempNo
            for (i in 1..ones) {
                res += map[1]
            }
        }
        return res
    }
}

fun main() {
    IntegerToRoman().apply {
        // require(intToRoman(3749) == "MMMDCCXLIX") { "3749 -> MMMDCCXLIX" }
        // require(intToRoman(58) == "LVIII") { "58 -> LVIII" }
        // require(intToRoman(5) == "V") { "5 -> V" }
    }
}