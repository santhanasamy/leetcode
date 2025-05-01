package leet

/**
 * Olog(m+n)
 */
class MedianOfTwoArray {
    fun findMedianSortedArrays1(array1: IntArray, array2: IntArray): Double {
        // Test 1
        // 0 1  2
        // 0 1  0
        // 1,3  2

        array1.forEach {

        }


        val length = array1.size + array2.size
        val mid = if (length.rem(2) == 0) {
            length / 2
        } else {
            (length / 2) + 1
        }

        return if (length.rem(2) == 0) {
            (array1.last() + array2.first()) / 2.toDouble()
        } else {
            val res = if (mid > array1.size) {
                array2[mid - array1.size - 1]
            } else {
                array1[mid - 1]
            }
            res / 2.toDouble()
        }
    }


    fun findMedianSortedArrays(array1: IntArray, array2: IntArray): Double {

        val merge = mutableListOf<Int>()
        var j = 0
        var k = 0
        for (i in 0 until array1.size + array2.size) {

            merge.add(i, if (j >= array1.size) {
                array2[k++]
            } else if (k >= array2.size) {
                array1[j++]
            } else {
                if (array1[j] > array2[k]) {
                    array2[k++]
                } else {
                    array1[j++]
                }
            })
        }

        //println(merge)
        return if (merge.size.rem(2) == 0) {
            val mid = merge.size / 2
            (merge.elementAt(mid) + merge.elementAt(mid - 1)).toDouble() / 2
        } else {
            merge.elementAt(merge.size / 2).toDouble()
        }

    }
}

fun main() {

    val obj = MedianOfTwoArray()

    var array1 = intArrayOf(1, 3)
    var array2 = intArrayOf(2)
    println(obj.findMedianSortedArrays(array1, array2))

    array1 = intArrayOf(1, 2)
    array2 = intArrayOf(3, 4)
    println(obj.findMedianSortedArrays(array1, array2))

}