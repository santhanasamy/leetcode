package leet.common

fun build2DArray(arrayStr: String): Array<IntArray> {

    val result = mutableListOf<IntArray>()
    arrayStr
        .replace("[[", "")
        .replace("]]", "")
        .split("],[").forEach {
            val temp: List<Int> = it.split(",").map { it.toInt() }
            result.add(temp.toIntArray())
        }
    return result.toTypedArray()
}

fun main() {
    build2DArray("[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]").apply {
        println(this)
    }
}