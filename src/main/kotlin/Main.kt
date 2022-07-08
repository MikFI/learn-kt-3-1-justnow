fun main(args: Array<String>) {
    val seconds = arrayOf(20,80,140,400,1350,4000,12_000,40_000,90_000,200_000, 500_000)
    for (second in seconds) {
        println(agoToText(second))
    }
}

fun agoToText(seconds: Int): String {
    val minutes = arrayOf("минут", "минуту", "минуты")
    val hours = arrayOf("часов", "час", "часа")
    return when (seconds) {
        in (0..60) -> "только что"
        in (61..60 * 60) -> "${seconds / 60} ${minutes[wordEndian(seconds / 60)]} назад"
        in ((60 * 60) + 1..24 * 60 * 60) -> "${seconds / 60 / 60} ${hours[wordEndian(seconds / 60 / 60)]} назад"
        in ((24 * 60 * 60) + 1..2 * 24 * 60 * 60) -> "сегодня"
        in ((2 * 24 * 60 * 60) + 1..3 * 24 * 60 * 60) -> "вчера"
        else -> "давно"
    }
}

fun wordEndian(timeValue: Int): Int {
    if (timeValue == 11) return 0
    return when (timeValue % 10) {
        1 -> 1
        in (2..4) -> 2
        else -> 0
    }
}



