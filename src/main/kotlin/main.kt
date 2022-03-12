const val MINUTES = 60
const val HOURS = 60 * 60
const val DAYS = 24 * 60 * 60
fun main() {

    val guest1 = "Петя"
    val guest2 = "Василий"
    val guest3 = "Ярослава"
    val guest4 = "Валентина"
    val guest5 = "Павел"
    val guest6 = "Мария"

    val second1 = 10
    val second2 = 10 * 60
    val second3 = 5 * 60 * 60
    val second4 = 25 * 60 * 60
    val second5 = 50 * 60 * 60
    val second6 = 4 * 24 * 60 * 60

    println("$guest1 был(а) ${agoToText(second1)}")
    println("$guest2 был(а) ${agoToText(second2)}")
    println("$guest3 был(а) ${agoToText(second3)}")
    println("$guest4 был(а) ${agoToText(second4)}")
    println("$guest5 был(а) ${agoToText(second5)}")
    println("$guest6 был(а) ${agoToText(second6)}")

}

fun agoToText(seconds: Int) = when (seconds) {
    in 0..MINUTES -> "только что"
    in (MINUTES + 1)..HOURS -> {
        val minutes = seconds / MINUTES
        "$minutes ${nameMinutesHours((minutes), isMinutes = true)} назад"
    }
    in (HOURS + 1)..DAYS -> {
        val hours: Int = seconds / HOURS
        "$hours ${nameMinutesHours(hours, false)} назад"
    }
    in DAYS + 1..2 * DAYS -> "сегодня"
    in 2 * DAYS + 1..3 * DAYS -> "вчера"
    !in 0..3 * DAYS + 1 -> "давно"
    else -> "Не определено"
}

fun nameMinutesHours(minutes: Int, isMinutes: Boolean) = when {
    minutes % 10 == 1 && minutes % 100 != 11 -> if (isMinutes) "минуту" else "час"
    minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> if (isMinutes) "минуты" else "часа"
    else -> if (isMinutes) "минут" else "часов"
}

