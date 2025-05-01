package leet

class RomanToInt {
//    I	1
//    V	5
//    X	10
//    L	50
//    C	100
//    D	500
//    M	1000
//  4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD), 900 (CM).

    fun romanToInt(num: String): Int {
        val map = mutableMapOf(
            ("I" to 1),
            ("IV" to 4),
            ("V" to 5),
            ("IX" to 9),
            ("X" to 10),
            ("XL" to 40),
            ("L" to 50),
            ("XC" to 90),
            ("C" to 100),
            ("CD" to 400),
            ("D" to 500),
            ("CM" to 900),
            ("M" to 1000)
        )

        var res = 0
        val tempNo: CharArray = num.toCharArray()
        var i = num.length - 1
        while (i >= 0) {
            val pre = tempNo.getOrElse(i - 1) { Char.MIN_VALUE }
            val cur = tempNo[i]

            res += map.getOrDefault("$pre$cur", null)?.let {
                i--
                it
            } ?: map["$cur"]!!
            i--
        }
        return res
    }
}

fun main() {
    RomanToInt().apply {
        require(romanToInt("MMMDCCXLIX") == 3749) { "3749 -> MMMDCCXLIX" }
        require(romanToInt("LVIII") == 58) { "58 -> LVIII" }
        // require(romanToInt("V") == 5) { "5 -> V" }


        println(romanToInt("DCCXCIX"))

    }
}