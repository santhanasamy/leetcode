package leet

import java.math.BigInteger

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {

    var min = BigInteger.valueOf(Long.MAX_VALUE)
    var max = BigInteger.valueOf(0)
    // Write your code here
    var res = BigInteger("0")
    arr.forEach { x ->

        if (x > max.longValueExact()) {
            max = BigInteger(x.toString())
        }
        if (x < min.longValueExact()) {
            min = BigInteger(x.toString())
        }

        res = res.add(x.toBigInteger())
    }
    println("${res - max} ${res - min} ")
}

fun main(args: Array<String>) {

    //  val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arrayOf(1, 3, 5, 7, 9))

    // 256741038 623958417 467905213 714532089 938071625
    // 2063136757 2744467344
    miniMaxSum(arrayOf(256741038, 623958417, 467905213, 714532089, 938071625))

}
