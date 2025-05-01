package leet.common

fun String.p(length: Int = 3): String {
    return String.format("%.${length}s", this)
}

fun Int.p(length: Int = 3): String {
    val format = "%${length}d"
    return String.format(format, this)
}